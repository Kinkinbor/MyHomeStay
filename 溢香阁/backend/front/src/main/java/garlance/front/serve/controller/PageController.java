package garlance.front.serve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {

    @GetMapping(value = {"/","index.html","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("header")
    public String header() {
        return "header";
    }

    @GetMapping("footer")
    public String footer() {
        return "footer";
    }

}
