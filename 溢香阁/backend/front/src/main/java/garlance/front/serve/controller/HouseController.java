package garlance.front.serve.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import garlance.common.result.R;
import garlance.front.serve.entity.HouseEntity;
import garlance.front.serve.entity.UserEntity;
import garlance.front.serve.responseEntity.HouseListResponseEntity;
import garlance.front.serve.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class HouseController {

    @Autowired
    private HouseService houseService;


//    @PostMapping(value = {"/houseListData"})
//    public R page(String city,String district,String text){
//        //定义要传的参数
//        Map<String,Object> map = new HashMap<>();
//        map.put("city",city);
//        map.put("district",district);
//        map.put("text",text);
//        //查询符合条件的房源
//        List<HouseEntity> byCondition = houseService.getByCondition(map);
//        return R.success(byCondition,byCondition.size());
//    }

    @PostMapping(value = {"/houseList"})
    public ModelAndView page1(@RequestParam String city , @RequestParam String district ,@RequestParam String text){
        Map<String,Object> map = new HashMap<>();
        ModelAndView modelAndView = new ModelAndView();
        map.put("city",city);
        map.put("district",district);
        map.put("text",text);
        //查询符合条件的房源
        List<HouseListResponseEntity> byCondition = houseService.getByCondition(map);
        String body = JSONObject.toJSONString(R.success(byCondition));
        Object parse1 = JSON.parse(body);
        String s = parse1.toString();
        JSON v = JSONObject.parseObject(s);
        modelAndView.addObject("data",v);
        modelAndView.setViewName("HomeList");
        return modelAndView;
    }

    @PostMapping(value = {"/getHouseListToJson"})
    public R getHouseListToJson(@RequestParam String city , @RequestParam String district ,@RequestParam String text){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        map.put("city",city);
        map.put("district",district);
        map.put("text",text);
        //查询符合条件的房源
        List<HouseListResponseEntity> byCondition = houseService.getByCondition(map);
        String body = JSONObject.toJSONString(R.success(byCondition));
        Object parse1 = JSON.parse(body);
        String s = parse1.toString();
        JSON v = JSONObject.parseObject(s);
        res.put("data",v);
        return R.success(res);
    }


    @GetMapping("HomeDetails")
    public String HomeDetails() {
        return "HomeDetails";
    }

}
