package com.jesper.seckill.controller;

import com.jesper.seckill.bean.User;
import com.jesper.seckill.redis.RedisService;
import com.jesper.seckill.result.CodeMsg;
import com.jesper.seckill.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiangyunxiong on 2018/5/18.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello, Jesper");
    }

    @RequestMapping("/Error")
    @ResponseBody
    public Result<String> error(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/Thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "Jesper");
        return "hello";
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Long> redisGet(){
       Long l1 = redisService.get("key1", Long.class);
       return Result.success(l1);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Boolean> redisSet(){
        Boolean b1 = redisService.set("key1", "hello, Jesper");
        return Result.success(b1);
    }


}
