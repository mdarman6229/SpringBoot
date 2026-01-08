package com.Test1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        int a = 10;
        int b = 20;
        int c = 30;
        int d=50;
        int e=10;
        int t=110;
        return "sum of a + b = " + (a+b+c+d+e+t);
    }

}
