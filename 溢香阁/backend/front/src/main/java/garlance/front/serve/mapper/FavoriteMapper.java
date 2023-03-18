package garlance.front.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.front.serve.entity.FavoriteEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavoriteMapper extends BaseMapper<FavoriteEntity> {
}
