package garlance.front.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.front.serve.entity.BookingEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingMapper extends BaseMapper<BookingEntity> {
}
