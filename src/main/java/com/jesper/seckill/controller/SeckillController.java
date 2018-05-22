package com.jesper.seckill.controller;

import com.jesper.seckill.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jiangyunxiong on 2018/5/22.
 */
@Controller
@RequestMapping("seckill")
public class SeckillController {

    @RequestMapping("/do_seckill")
    public String list(Model model, User user, @RequestParam("goodsId")long goodsId) {
        model.addAttribute("user", user);
        if (user == null){
            return "login";
        }
        return null;
    }

}
