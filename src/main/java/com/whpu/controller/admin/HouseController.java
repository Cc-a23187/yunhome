package com.whpu.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whpu.mapper.HouseMapper;
import com.whpu.pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author cc
 * @create 2020-06-17-13:40
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseMapper houseMapper;

    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1")Integer pageNo,
                       @RequestParam(defaultValue = "3")Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);

        List<House> houses = houseMapper.getHouse();

        new PageInfo<>(houses);
        //3.封装pageInfo
        PageInfo<House> houseInfo = (PageInfo<House>) new PageInfo<>(houses);
        //4.存model
        model.addAttribute("houseInfo",houseInfo);
        //5.跳转showHouse.html
        return "admin/house/show_house";
    }
}
