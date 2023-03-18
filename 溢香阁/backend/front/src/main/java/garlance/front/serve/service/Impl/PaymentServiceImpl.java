package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.PaymentEntity;
import garlance.front.serve.mapper.PaymentMapper;
import garlance.front.serve.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, PaymentEntity> implements PaymentService {

}
