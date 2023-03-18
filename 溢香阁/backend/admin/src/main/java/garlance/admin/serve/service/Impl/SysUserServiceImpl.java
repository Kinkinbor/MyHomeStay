package garlance.admin.serve.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.admin.serve.entity.SysUserEntity;
import garlance.admin.serve.mapper.SysUserMapper;
import garlance.admin.serve.service.SysUserService;
import garlance.common.result.R;
import garlance.common.utils.PasswordUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Autowired
    private MemorySessionDAO sessionDAO;

    @Override
    public R login(Map<String,String> content) {
        //某个主体
        Subject subject = SecurityUtils.getSubject();
        //获取当前session
        Session session = subject.getSession();
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(content.get("username"), content.get("password"));
            //登录验证，成功就往下执行，失败就走异常
            subject.login(token);
            Collection<Session> sessions = sessionDAO.getActiveSessions();
            for (Session session1 : sessions){
                //重复登录时，把第一个session剔除
                if (content.get("username").equals(session1.getAttribute("loginedUser"))){
                    session1.setTimeout(0);
                    log.error("管理员：[" + content.get("username") + "]重复登录，已把之前登录剔除");
                    break;
                }
            }
            session.setAttribute("loginedUser", content.get("username"));
            //60分钟无操作后登出
            session.setTimeout(60 * 60 * 1000);
            session.setAttribute("account",SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
            return R.success("登录成功",1);
        }catch (UnknownAccountException | LockedAccountException e){
            return R.error(e.getMessage());
        }catch (IncorrectCredentialsException e){
            return R.error("密码错误");
        }catch (AuthenticationException e){
            return R.error("账号验证失败");
        }
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        try{
            if (subject.isAuthenticated()){
                subject.logout();
            }

        }catch (Exception e){
            log.debug(e.getMessage());
        }
    }

    @Override
    public int updateAdmin(Map<String, String> map) {
        String account = map.get("account");
        LambdaQueryWrapper<SysUserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SysUserEntity::getAccount,account);
        SysUserEntity one = baseMapper.selectOne(lqw);
        if (one == null){
            return -2;  //该用户已不存在
        }
        String nickname = map.get("nickname");
        String salt = PasswordUtils.getGenerateSalt();
        String oldPass = PasswordUtils.sha256(map.get("oldPass"),one.getSalt());
        String password = PasswordUtils.sha256(map.get("pass"),salt);
        System.out.println(salt);
        lqw.eq(SysUserEntity::getPassword,oldPass);
        SysUserEntity rest = baseMapper.selectOne(lqw);
        if (rest == null){
            return -1; //密码不正确
        }
        return baseMapper.updateAdmin(account,nickname,password,salt);
    }

}
