package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.DistrictEntity;
import garlance.front.serve.mapper.DistrictMapper;
import garlance.front.serve.service.DistrictService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, DistrictEntity> implements DistrictService {
    @Override
    public DistrictEntity getOne(String code) {
        LambdaQueryWrapper<DistrictEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Strings.isNotEmpty(code), DistrictEntity::getTreeCode,code);
        return baseMapper.selectOne(lqw);
    }
}
