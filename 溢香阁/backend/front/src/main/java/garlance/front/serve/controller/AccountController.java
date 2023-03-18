package garlance.front.serve.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Api(tags = "用户登录")
@Controller
public class AccountController {

    @GetMapping(value = {"/login"})
    public String loginPage(){
        return "login";
    }

    @GetMapping(value = {"/logout"})
    public String logout(){
        return "/";
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/loginHandling")
    public String login(){
        return "/";
    }

}
