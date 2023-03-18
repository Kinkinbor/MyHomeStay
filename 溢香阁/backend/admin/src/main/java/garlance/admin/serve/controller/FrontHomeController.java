package garlance.admin.serve.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import garlance.admin.serve.service.FrontHomeService;
import garlance.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class FrontHomeController {
    @Autowired
    private FrontHomeService frontHomeService;


    //删除房源
    @PostMapping(value = "/del")
    public R del(@RequestBody List<Integer> ids) {
        int del = frontHomeService.del(ids);
        if (del == 0) {
            return R.error("删除失败");
        }
        return R.success("删除成功", del);
    }

    // 查询房源
    @GetMapping("/selectPage")
    public R selectPage(Integer page, Integer limit, String homeName,String status,String start,String end) {
        List<Object> list = frontHomeService.getPage(page, limit, homeName,status,start,end);
        IPage page1 = (IPage) list.get(0);
        return R.success(page1.getRecords(), (Integer) list.get(1));
    }


    //下架，上架，审核房源
    @PostMapping("/status")
    public R status(@RequestBody List<String> status){
        int num = frontHomeService.status(status);
        if(num != 1){
            return R.error("更新失败",num);
        }
        return R.success("更新成功",num);
    }
}
