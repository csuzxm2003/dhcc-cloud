package com.itmuch.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${name}")
    private  String name;
    @Value("${age}")
    private  String age;
    @Value("${sex}")
    private  String sex="女";

    @RequestMapping("/test")
    public String test(){
        return "你好，我是"+name+",年龄："+age+"岁，我是个："+sex+"人。";
    }
}