package garlance.admin.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import garlance.common.utils.PasswordUtils;
import garlance.admin.serve.entity.SysUserEntity;
import garlance.admin.serve.mapper.SysUserMapper;
import org.apache.logging.log4j.util.Strings;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证，登录的时候会用到
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从被shiro封装成的token取出我们传入的username
        String username = (String) authenticationToken.getPrincipal();
        //去缓存或数据库查询
        LambdaQueryWrapper<SysUserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Strings.isNotEmpty(username),SysUserEntity::getAccount,username);
        SysUserEntity account = sysUserMapper.selectOne(lqw);

        //如果用户名不匹配，则报错用户名不存在
        if(account == null){
            throw new UnknownAccountException("账号不存在");
        }else if(!account.getIsDel().equals("0")){
            throw new UnknownAccountException("账号已冻结");
        }
        //返回新封装的认证实体，传入的是用户名 数据库查出来的密码 和 当前realm的名字
        return new SimpleAuthenticationInfo(account, account.getPassword(), ByteSource.Util.bytes(account.getSalt()),getName());
    }


    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        //密码加密 类型
        shaCredentialsMatcher.setHashAlgorithmName(PasswordUtils.HASH_ALGORITHM_NAME_SHA256);
        shaCredentialsMatcher.setHashIterations(PasswordUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
