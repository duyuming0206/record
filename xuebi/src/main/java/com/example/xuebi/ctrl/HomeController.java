package com.example.xuebi.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("gohome")
    public String gohome(){
        return "regist";
    }
}
