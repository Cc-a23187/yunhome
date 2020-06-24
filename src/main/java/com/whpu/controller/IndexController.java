package com.whpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cc
 * @create 2020-06-15-10:03
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        //跳转index.html
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {
        //跳转admin.html
        return "/admin/admin";
    }

    //访问前台首页
    @RequestMapping("/front")
    public String front() {
        //跳转index.html
        return "front/home_index";
    }
}
