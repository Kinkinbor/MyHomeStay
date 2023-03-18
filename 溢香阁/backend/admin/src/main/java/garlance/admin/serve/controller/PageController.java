package garlance.admin.serve.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {

    @GetMapping("html/{one}/{two}.html")
    public String page(@PathVariable("one") String one, @PathVariable("two") String two) {
        Map<Character,Integer> map = new HashMap<>();
        return "html/" + one + "/" + two;
    }

    @GetMapping("html/{one}.html")
    public String page(@PathVariable("one") String one) {
        return "html/" + one;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping(value = {"/login", "/admin", "login.html"})
    public String adminLogin() {
        if (SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/index";
        }
        return  "login";
    }

    @GetMapping(value = {"/","index.html","/index"})
    public String index(){
        return "index";
    }

}
