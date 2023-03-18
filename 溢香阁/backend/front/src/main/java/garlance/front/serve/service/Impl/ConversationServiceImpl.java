package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.ConversationEntity;
import garlance.front.serve.mapper.ConversationMapper;
import garlance.front.serve.service.ConversationService;
import org.springframework.stereotype.Service;

@Service
public class ConversationServiceImpl extends ServiceImpl<ConversationMapper, ConversationEntity> implements ConversationService {

}
