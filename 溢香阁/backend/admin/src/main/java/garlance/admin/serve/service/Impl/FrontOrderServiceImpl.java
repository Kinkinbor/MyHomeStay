package garlance.admin.serve.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.admin.serve.entity.FrontOrderEntity;
import garlance.admin.serve.entity.FrontUserEntity;
import garlance.admin.serve.mapper.FrontOrderMapper;
import garlance.admin.serve.service.FrontOrderService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrontOrderServiceImpl extends ServiceImpl<FrontOrderMapper, FrontOrderEntity> implements FrontOrderService {
    @Override
    public int del(List<Integer> ids) {
        int count = 0;
        for (int id : ids) {
            if (id == 999){
                continue;
            }
            count += baseMapper.del(id);
        }
        return count;
    }

    @Override
    public List<Object> getPage(Integer page, Integer pageSize,String orderId,String homeId,String paymentStatus,String start,String end) {
        List<Object> list = new ArrayList<>();
        IPage<FrontOrderEntity> p = new Page(page,pageSize);
        LambdaQueryWrapper<FrontOrderEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(FrontOrderEntity::getIsDel,0);   //筛选未删除的记录
        lqw.eq(Strings.isNotEmpty(orderId),FrontOrderEntity::getId,orderId);
        lqw.eq(Strings.isNotEmpty(homeId),FrontOrderEntity::getHomeId,homeId);
        lqw.eq(FrontOrderEntity::getPaymentStatus,paymentStatus);
        lqw.ge(start != null && !"".equals(start),FrontOrderEntity::getCreateTime,start + " 00:00:00");
        lqw.le(end != null && !"".equals(end),FrontOrderEntity::getCreateTime,end + " 23:59:59");
        lqw.orderByDesc(FrontOrderEntity::getCreateTime);
        list.add(baseMapper.selectPage(p, lqw));
        list.add(baseMapper.selectCount(lqw));
        return list;
    }
}
