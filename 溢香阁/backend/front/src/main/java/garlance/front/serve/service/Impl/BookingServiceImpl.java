package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.BookingEntity;
import garlance.front.serve.mapper.BookingMapper;
import garlance.front.serve.service.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper, BookingEntity> implements BookingService {
}
