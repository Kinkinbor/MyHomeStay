package garlance.admin.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.admin.serve.entity.FrontUserEntity;

import java.util.List;
import java.util.Map;

public interface FrontUserService extends IService<FrontUserEntity> {
    int del(List<Integer> user);  //删除
    List<Object> getPage(Integer page, Integer pageSize,String account,String mobile,String start,String end); //分页
    int add(FrontUserEntity user);//添加
    int update(Map<String,String> user);//更新
    int status(List<String> status);  //启用或禁用
}
