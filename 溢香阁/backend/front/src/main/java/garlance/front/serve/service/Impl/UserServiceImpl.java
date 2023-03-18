package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.MyUser;
import garlance.front.serve.entity.UserEntity;
import garlance.front.serve.mapper.UserMapper;
import garlance.front.serve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public MyUser getUser(String UserName) {
        LambdaQueryWrapper<UserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(UserName != null && UserName != "",UserEntity::getUsername,UserName);
        UserEntity userEntity = baseMapper.selectOne(lqw);
//        String password = userEntity.getPassword();
//        String encode = passwordEncoder.encode(password);
//        System.out.println("加密前的密码："+ password);
//        System.out.println("加密后的密码："+ encode);
        MyUser myUser;
        if (userEntity != null) {
            myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(), userEntity.getStatus().equals("1") ? true : false, true, true, true, getAuthority());
            myUser.setUserEntity(userEntity);
            return myUser;
        }
        return null;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE"));
        return list;
    }
}
