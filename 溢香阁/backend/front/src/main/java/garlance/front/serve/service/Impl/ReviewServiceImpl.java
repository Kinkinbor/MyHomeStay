package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.ReviewEntity;
import garlance.front.serve.mapper.ReviewMapper;
import garlance.front.serve.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, ReviewEntity> implements ReviewService {

}
