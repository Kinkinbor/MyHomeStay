package garlance.front.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.front.serve.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<PaymentEntity> {
}
