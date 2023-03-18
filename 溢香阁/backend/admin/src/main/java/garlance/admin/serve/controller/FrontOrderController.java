package garlance.admin.serve.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import garlance.admin.serve.service.FrontOrderService;
import garlance.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class FrontOrderController {

    @Autowired
    private FrontOrderService frontOrderService;

    @GetMapping("/selectPage")
    public R selectPage(Integer page, Integer limit, String orderId, String homeId, String paymentStatus, String start, String end) {
        List<Object> list = frontOrderService.getPage(page, limit, orderId,homeId,paymentStatus,start,end);
        IPage page1 = (IPage) list.get(0);
        return R.success(page1.getRecords(), (Integer) list.get(1));
    }

    @PostMapping(value = "/del")
    public R del(@RequestBody List<Integer> ids) {
        int del = frontOrderService.del(ids);
        if (del == 0) {
            return R.error("删除失败");
        }
        return R.success("删除成功", del);
    }

}
