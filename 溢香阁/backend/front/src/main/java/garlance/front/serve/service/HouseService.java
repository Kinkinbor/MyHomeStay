package garlance.front.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.front.serve.entity.HouseEntity;
import garlance.front.serve.responseEntity.HouseListResponseEntity;

import java.util.List;
import java.util.Map;

public interface HouseService extends IService<HouseEntity> {
    List<HouseListResponseEntity> getByCondition(Map<String,Object> map);
}
