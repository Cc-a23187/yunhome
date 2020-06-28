package com.whpu.controller;

import cn.keking.anti_reptile.annotation.AntiReptile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 * @create 2020-06-28-22:19
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @AntiReptile
    @GetMapping("")
    public String demo() {
        return "Hello，World!";
    }

}