package garlance.front.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.front.serve.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

public interface UserService extends IService<UserEntity>{
    User getUser(String UserName);
}
