package garlance.admin.serve.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.admin.serve.entity.FrontHomeEntity;
import garlance.admin.serve.entity.FrontUserEntity;
import garlance.admin.serve.mapper.FrontHomeMapper;
import garlance.admin.serve.service.FrontHomeService;
import org.apache.logging.log4j.util.Strings;
import org.apache.shiro.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrontHomeServiceImpl extends ServiceImpl<FrontHomeMapper, FrontHomeEntity> implements FrontHomeService {

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
    public List<Object> getPage(Integer page, Integer pageSize,String homeName,String status,String start,String end) {
        List<Object> list = new ArrayList<>();
        IPage<FrontHomeEntity> p = new Page(page,pageSize);
        LambdaQueryWrapper<FrontHomeEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(FrontHomeEntity::getIsDel,0);   //筛选未删除的记录
        lqw.like(Strings.isNotEmpty(homeName),FrontHomeEntity::getName,homeName);
        lqw.eq(Strings.isNotEmpty(status),FrontHomeEntity::getStatus,status);
        lqw.ge(start != null && !"".equals(start),FrontHomeEntity::getCreateTime,start + " 00:00:00");
        lqw.le(end != null && !"".equals(end),FrontHomeEntity::getCreateTime,end + " 23:59:59");
        lqw.orderByDesc(FrontHomeEntity::getCreateTime);
        list.add(baseMapper.selectPage(p, lqw));
        list.add(baseMapper.selectCount(lqw));
        return list;
    }

    @Override
    public int status(List<String> status) {
        Integer id = Integer.parseInt(status.get(0));   // id
        String state = status.get(1);  // 当前网页房源的状态
        String descState = status.get(2);//预计要使房源成为的状态
        LambdaQueryWrapper<FrontHomeEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(FrontHomeEntity::getId,id);
        lqw.eq(FrontHomeEntity::getIsDel,"0");
        FrontHomeEntity isExist = baseMapper.selectOne(lqw);
        if (isExist == null){
            return -999;  //代表房源不存在了
        }
        lqw.eq(FrontHomeEntity::getStatus, state);
        FrontHomeEntity one = baseMapper.selectOne(lqw);
        if(one == null){
            return -998; //代表房源已经被其他管理员操作
        }
        return baseMapper.status(id,descState);
    }

}
