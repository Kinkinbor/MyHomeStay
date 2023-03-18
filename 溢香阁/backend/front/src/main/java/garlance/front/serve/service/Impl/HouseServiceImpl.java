package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.HouseEntity;
import garlance.front.serve.entity.MyUser;
import garlance.front.serve.entity.UserEntity;
import garlance.front.serve.mapper.HouseMapper;
import garlance.front.serve.responseEntity.HouseListResponseEntity;
import garlance.front.serve.service.HouseService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, HouseEntity> implements HouseService {

    @Autowired
    private FavoriteServiceImpl favoriteService;


    @Override
    public List<HouseListResponseEntity> getByCondition(Map<String, Object> map) {
        String userId = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof MyUser) {
                MyUser userDetails = (MyUser) principal;
                String username = userDetails.getUsername();
                UserEntity user = userDetails.getUserEntity();
                userId = user.getId();
            }
        }
        LambdaQueryWrapper<HouseEntity> lqw = new LambdaQueryWrapper<>();
        if (map != null) {
            String city = String.valueOf(map.get("city")); //城市
            String district = String.valueOf(map.get("district")); //区域
            String text = String.valueOf(map.get("text")); //文本
            lqw.eq(Strings.isNotEmpty(city), HouseEntity::getCity, city)
                    .eq(Strings.isNotEmpty(district), HouseEntity::getDistrict, district)
                    .eq(HouseEntity::getStatus, "1")
                    .like(Strings.isNotEmpty(text) && !text.equals(""), HouseEntity::getDescription, text)
                    .or()
                    .eq(Strings.isNotEmpty(city), HouseEntity::getCity, city)
                    .eq(Strings.isNotEmpty(district), HouseEntity::getDistrict, district)
                    .eq(HouseEntity::getStatus, "1")
                    .like(Strings.isNotEmpty(text) && !text.equals(""), HouseEntity::getTitle, text);
        }
        List<HouseEntity> houseEntities = baseMapper.selectList(lqw);

        List<HouseListResponseEntity> hl = new ArrayList<>();
        for (HouseEntity h : houseEntities) {
            HouseListResponseEntity temp = new HouseListResponseEntity();
            int i = favoriteService.selectFavorite(h.getId(), userId);
            temp.setIsFavorite(i == 1 ? "active" : "");
            temp.setHouseEntity(h);
            hl.add(temp);
        }
        return hl;
    }
}
