package garlance.admin.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.admin.serve.entity.FrontHomeEntity;

import java.util.List;

public interface FrontHomeService extends IService<FrontHomeEntity> {
    int del(List<Integer> home);  //删除
    List<Object> getPage(Integer page, Integer pageSize,String homeName,String status,String start,String end); //分页
    int status(List<String> status);  //上架与下架
}
