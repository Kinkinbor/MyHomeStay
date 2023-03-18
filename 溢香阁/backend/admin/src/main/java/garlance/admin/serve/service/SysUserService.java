package garlance.admin.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.admin.serve.entity.SysUserEntity;
import garlance.common.result.R;

import java.util.Map;

public interface SysUserService extends IService<SysUserEntity> {
    R login(Map<String,String> content);
    void logout();
    int updateAdmin(Map<String,String> map);
}