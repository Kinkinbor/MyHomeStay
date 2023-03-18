package garlance.front.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.front.serve.entity.FavoriteEntity;

public interface FavoriteService extends IService<FavoriteEntity> {
    int update(String HouseID,String UserID,String Status);

    int selectFavorite(String HouseID,String UserID);
}
