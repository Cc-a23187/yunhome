package com.whpu.controller.admin;

import cn.keking.anti_reptile.annotation.AntiReptile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whpu.mapper.DistrictMapper;
import com.whpu.mapper.HouseMapper;
import com.whpu.mapper.TypeMapper;
import com.whpu.mapper.UsersMapper;
import com.whpu.pojo.District;
import com.whpu.pojo.House;
import com.whpu.pojo.Type;
import com.whpu.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
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

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    DistrictMapper districtMapper;

    @AntiReptile
    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNo,
                       @RequestParam(defaultValue = "3") Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);

        List<House> houses = houseMapper.getHouse();

        new PageInfo<>(houses);
        //3.封装pageInfo
        PageInfo<House> houseInfo = (PageInfo<House>) new PageInfo<>(houses);
        //4.存model
        model.addAttribute("houseInfo", houseInfo);
        //5.跳转showHouse.html
        return "admin/house/show_house";
    }

    @RequestMapping("addPage")
    public String addHousePage(Model model) {
        //查询出所有的用户信息
        List<Users> users = usersMapper.getAllUsers();
        //2.查询出所有的类型信息
        List<Type> types = typeMapper.selectAll();
        //3.查询出所有的区域信息:城区 (和 街道)
        List<District> districts = districtMapper.selectDisArea(1);
        //4.上述集合存入model
        model.addAttribute("users", users);
        model.addAttribute("types", types);
        model.addAttribute("districts", districts);
        System.out.println(districts);
        //5.跳转到新增页面
        return "admin/house/add_house";
    }

    @RequestMapping("/getStreetsById")
    @ResponseBody//城区和街道二级联动
    public List<District> streets(Integer id) {
        return districtMapper.selectDisArea(id);
    }


    @RequestMapping("/add")//实现房源信息的新增
    public String addHouse(House house) {
        System.out.println(house);
        houseMapper.addHouse(house);
        return "redirect:/admin";
    }
/*    @RequestMapping("/delete")//实现房源信息的新增
    public String deleteHouse(House house){
        System.out.println(house);
        houseMapper.deleteHouse(house);
        return "redirect:/admin";
    }*/
}
