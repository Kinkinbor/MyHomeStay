package garlance.admin.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.admin.serve.entity.FrontOrderEntity;

import java.util.List;

public interface FrontOrderService extends IService<FrontOrderEntity> {
    int del(List<Integer> user);  //删除
    List<Object> getPage(Integer page, Integer pageSize,String orderId,String homeId,String paymentStatus,String start,String end); //分页
}
