package garlance.admin.serve.controller;

import garlance.admin.serve.entity.SysUserEntity;
import garlance.admin.serve.service.SysUserService;
import garlance.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
@Slf4j
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping(value = {"/login"})
    @ResponseBody
    public R doLogin(@RequestBody Map<String,String> param){
        return sysUserService.login(param);
    }

    @GetMapping("/logout")
    public String logout(){
        sysUserService.logout();
        return "login";
    }

    @PostMapping("/getAdminInfo")
    @ResponseBody
    public R getAdmin(){
        SysUserEntity account = (SysUserEntity)SecurityUtils.getSubject().getSession().getAttribute("account");
        account.setSalt(null);
        account.setPassword(null);
        return R.success(account,1);
    }

    @PostMapping("/updateAdmin")
    @ResponseBody
    public R addAdmin(@RequestBody Map<String,String> map){
        int num = sysUserService.updateAdmin(map);
        if (num != 1){
            return R.error("更新失败",num);
        }
        return R.success("更新成功",num);
    }
}
