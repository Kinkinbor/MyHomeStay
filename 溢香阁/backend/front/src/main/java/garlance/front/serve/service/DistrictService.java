package garlance.front.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import garlance.front.serve.entity.DistrictEntity;

public interface DistrictService extends IService<DistrictEntity> {
    DistrictEntity getOne(String code);
}
