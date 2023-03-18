package garlance.admin.serve.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.admin.serve.entity.FrontUserEntity;
import garlance.admin.serve.mapper.FrontUserMapper;
import garlance.admin.serve.service.FrontUserService;
import garlance.common.utils.NumberGenerator;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FrontUserServiceImpl extends ServiceImpl<FrontUserMapper, FrontUserEntity> implements FrontUserService {

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
    public List<Object> getPage(Integer page, Integer pageSize,String account,String mobile,String start,String end) {
        List<Object> list = new ArrayList<>();
        IPage<FrontUserEntity> p = new Page(page,pageSize);
        LambdaQueryWrapper<FrontUserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(FrontUserEntity::getIsDel,0);   //筛选未删除的记录
        lqw.like(Strings.isNotEmpty(account),FrontUserEntity::getAccount,account);
        lqw.like(Strings.isNotEmpty(mobile),FrontUserEntity::getMobile,mobile);
        lqw.ge(start != null && !"".equals(start),FrontUserEntity::getCreateTime,start + " 00:00:00");
        lqw.le(end != null && !"".equals(end),FrontUserEntity::getCreateTime,end + " 23:59:59");
        lqw.orderByDesc(FrontUserEntity::getCreateTime);
        list.add(baseMapper.selectPage(p, lqw));
        list.add(baseMapper.selectCount(lqw));
        return list;
    }

    @Override
    public int add(FrontUserEntity user) {
        user.setId(NumberGenerator.getNumber(9));
        user.setPhoto("C:\\Users\\BENGENER\\Desktop\\头像.png");
        user.setIsDisabled("0");
        user.setIsDel("0");
        user.setBalance("0.00");
        user.setCreateTime(new java.sql.Date(new Date().getTime()));
        user.setUpdateTime(new java.sql.Date(new Date().getTime()));
        LambdaQueryWrapper<FrontUserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(FrontUserEntity::getAccount,user.getAccount());
        FrontUserEntity one = baseMapper.selectOne(lqw);
        if (one != null){   // 当前用户已存在
            return 0;
        }
        return baseMapper.insert(user);
    }

    @Override
    public int update(Map<String,String> map) {
        String account = map.get("account");
        String nickname = map.get("nickname");
        String gender = map.get("gender");
        String balance = map.get("balance");
        LambdaQueryWrapper<FrontUserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(FrontUserEntity::getAccount,account);
        FrontUserEntity isVal = baseMapper.selectOne(lqw);
        if (isVal == null){
            return -2;  //该用户根本不存在
        }
        lqw.eq(FrontUserEntity::getIsDel,0);
        FrontUserEntity isDel = baseMapper.selectOne(lqw);
        if (isDel == null){
            return -1; //表示该用户已被删除
        }
        if (account.equals(isDel.getAccount()) && nickname.equals(isDel.getNickname()) && gender.equals(isDel.getGender()) && balance.equals(isDel.getBalance())){
            return 0;  //表示前端传过来的信息未变，不必修改（修改失败）
        }
        return baseMapper.update(account,nickname,gender,balance);
    }

    @Override
    public int status(List<String> status) {
        Integer id = Integer.parseInt(status.get(0));   // id
        String state = status.get(1).equals("停用") ? "1" : "0";  // 当前网页的用户状态
        LambdaQueryWrapper<FrontUserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(FrontUserEntity::getId,id);
        lqw.eq(FrontUserEntity::getIsDel,"0");
        FrontUserEntity isExist = baseMapper.selectOne(lqw);
        if (isExist == null){
            return -999;  //代表用户不存在了
        }
        lqw.eq(FrontUserEntity::getIsDisabled, state);
        FrontUserEntity one = baseMapper.selectOne(lqw);
        if(one == null){
            return -998; //代表用户已经被其他管理员操作
        }
        return baseMapper.status(id,state.equals("0") ? "1" : "0");
    }

}
