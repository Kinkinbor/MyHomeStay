package garlance.front.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.front.serve.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
