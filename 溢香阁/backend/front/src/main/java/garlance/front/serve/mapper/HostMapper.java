package garlance.front.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.front.serve.entity.HostEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HostMapper extends BaseMapper<HostEntity> {
}
