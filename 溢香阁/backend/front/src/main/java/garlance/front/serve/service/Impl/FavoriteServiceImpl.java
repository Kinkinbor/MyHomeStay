package garlance.front.serve.service.Impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.FavoriteEntity;
import garlance.front.serve.entity.HouseEntity;
import garlance.front.serve.mapper.FavoriteMapper;
import garlance.front.serve.service.FavoriteService;
import org.apache.catalina.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, FavoriteEntity> implements FavoriteService {

    @Autowired
    private HouseServiceImpl houseService;

    @Override
    public int update(String HouseID, String UserID, String Status) {
        LambdaQueryWrapper<FavoriteEntity> lqw = new LambdaQueryWrapper<>();
        //查询房源状态，如果是正常状态就执行，不正常的话就直接返回
        LambdaQueryWrapper<HouseEntity> lqwH = new LambdaQueryWrapper<>();
        lqwH.eq(Strings.isNotEmpty(HouseID),HouseEntity::getId,HouseID);
        HouseEntity house = houseService.getOne(lqwH);
        if (house == null || !house.getStatus().equals("1")){
            return -1;
        }
        //查询收藏状态
        lqw.eq(Strings.isNotEmpty(HouseID), FavoriteEntity::getHouseID, HouseID);
        lqw.eq(Strings.isNotEmpty(UserID), FavoriteEntity::getUserID, UserID);
        FavoriteEntity one = baseMapper.selectOne(lqw);
        if (one == null) {
            FavoriteEntity favoriteEntity = new FavoriteEntity();
            favoriteEntity.setId("1" + RandomUtil.randomNumbers(5));
            favoriteEntity.setHouseID(HouseID);
            favoriteEntity.setUserID(UserID);
            favoriteEntity.setStatus("1");
            favoriteEntity.setCreateTime(DateTime.now());
            favoriteEntity.setUpdateTime(DateTime.now());
            return baseMapper.insert(favoriteEntity);
        }
        //表示已经更新过了，无需更新
        if (!one.getStatus().equals(Status)) {
            return 2;
        }
        one.setStatus(one.getStatus().equals("0") ? "1" : "0");
        one.setUpdateTime(DateTime.now());
        return baseMapper.update(one, lqw);
    }

    @Override
    public int selectFavorite(String HouseID, String UserID) {
        LambdaQueryWrapper<FavoriteEntity> lqw = new LambdaQueryWrapper<>();
        //查询收藏状态
        lqw.eq(Strings.isNotEmpty(HouseID), FavoriteEntity::getHouseID, HouseID);
        lqw.eq(Strings.isNotEmpty(UserID), FavoriteEntity::getUserID, UserID);
        FavoriteEntity favoriteEntity = baseMapper.selectOne(lqw);
        //已取消收藏或者从未插入过订单
        if (favoriteEntity == null || favoriteEntity.getStatus().equals("0")) {
            return 0;
        }
        //已收藏
        return 1;
    }
}
