package garlance.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import garlance.admin.serve.entity.FrontUserEntity;
import garlance.admin.serve.service.FrontUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class AdminApplicationTests {
    @Autowired
    private FrontUserService frontUserService;
    @Test
    void contextLoads() {
//        List<FrontUserEntity> lists = frontUserService.getPage(new HashMap<>());
//        for (FrontUserEntity user: lists){
//            System.out.println(user.getAccount());
//        }
    }

}
