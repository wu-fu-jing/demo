package com.pre.wfj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class test {
    @RequestMapping("/test1")
    public String test1(){
        return "不需要登录";
    }
    @RequestMapping("/test2")
    public String test2(){
        return "需要登录";
    }
}
