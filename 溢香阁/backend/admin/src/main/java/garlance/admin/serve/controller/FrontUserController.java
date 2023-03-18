package garlance.admin.serve.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import garlance.admin.serve.entity.FrontUserEntity;
import garlance.admin.serve.service.FrontUserService;
import garlance.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class FrontUserController {
    @Autowired
    private FrontUserService frontUserService;

    @PostMapping("/add")
    public R add(@RequestBody FrontUserEntity user) {
        int add = frontUserService.add(user);
        if (add == 0) {
            return R.error("添加失败",0l);
        }
        return R.success("添加成功", add);
    }

    @PostMapping(value = "/del")
    public R del(@RequestBody List<Integer> ids) {
        int del = frontUserService.del(ids);
        if (del == 0) {
            return R.error("删除失败");
        }
        return R.success("删除成功", del);
    }

    @RequestMapping("/update")
    public R update(@RequestBody Map<String,String> map) {
        int update = frontUserService.update(map);
        if (update != 1) {
            return R.error("更新失败",update);
        }
        return R.success("更新成功", update);
    }

    @GetMapping("/selectPage")
    public R selectPage(Integer page, Integer limit, String account,String mobile,String start,String end) {
        List<Object> list = frontUserService.getPage(page, limit, account,mobile,start,end);
        IPage page1 = (IPage) list.get(0);
        return R.success(page1.getRecords(), (Integer) list.get(1));
    }

    @PostMapping("/status")
    public R status(@RequestBody List<String> status){
        int num = frontUserService.status(status);
        if(num != 1){
            return R.error("更新失败",num);
        }
        return R.success("更新成功",num);
    }


}
