package garlance.front.serve.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import garlance.front.serve.entity.HostEntity;
import garlance.front.serve.mapper.HostMapper;
import garlance.front.serve.service.HostService;
import org.springframework.stereotype.Service;

@Service
public class HostServiceImpl extends ServiceImpl<HostMapper, HostEntity> implements HostService {
}
