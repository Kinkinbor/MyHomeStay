package garlance.front.serve.controller;

import cn.hutool.core.util.RandomUtil;
import garlance.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsEndpoint {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 发送验证码接口
     * @param phone
     * @return
     */
    @GetMapping("/sendCode")
    public R smsCode(String phone){
        // 1. 获取到手机号
        log.info(phone + "请求获取验证码");
        // 2. 模拟调用短信平台获取验证码，以手机号为KEY，验证码为值，存入Redis，过期时间一分钟
        String code = RandomUtil.randomNumbers(6);
//        redisTemplate.opsForValue().setIfAbsent(phone, code, 60, TimeUnit.SECONDS);
//        String saveCode = redisTemplate.opsForValue().get(phone);// 缓存中的code
//        Long expire = redisTemplate.opsForValue().getOperations().getExpire(phone, TimeUnit.SECONDS); // 查询过期时间
        // 3. 验证码应该通过短信发给用户，这里直接返回吧
        Map<String,String> result=new HashMap<>();
        result.put("code",code);
        result.put("过期时间","60秒");
        return R.success(result);
    }

    /**
     * 验证手机号验证码接口
     * @param phone
     * @return
     */
    @PostMapping("/smsLogin")
    public Map<String,String> smsLogin(@RequestBody String phone,@RequestBody String code){

        return new HashMap<>();
    }
}
