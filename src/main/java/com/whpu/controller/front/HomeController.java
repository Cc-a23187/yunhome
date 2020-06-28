package com.whpu.controller.front;

import cn.keking.anti_reptile.annotation.AntiReptile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whpu.mapper.DistrictMapper;
import com.whpu.mapper.HouseMapper;
import com.whpu.mapper.TypeMapper;
import com.whpu.pojo.District;
import com.whpu.pojo.House;
import com.whpu.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cc
 * @create 2020-06-19-14:10
 */
@RequestMapping("/home")
@Controller
public class HomeController {
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private TypeMapper typeMapper;

    //进入home_list页面
    @AntiReptile
    @RequestMapping("/list")
    public String list(Model model){
        //1.查询城区
        List<District> districts = districtMapper.selectDisArea(1);
        //2.查询房型
        List<Type> types = typeMapper.selectAll();
        //3.存入model
        model.addAttribute("districts",districts);
        model.addAttribute("types",types);
        System.out.println(districts);
        System.out.println(types);
        //4.跳到房源展示页面
        return "front/home_list";
    }

    //异步请求展示房源数据
    @RequestMapping("/showHomeList")
    @ResponseBody
    public PageInfo<House> showHomeList(@RequestParam(defaultValue="1") Integer pageNum,
                                        @RequestParam(defaultValue="8") Integer pageSize,
                                        String district_id,String type_id,String area,String price){
        //将所有的条件封装到map
        Map<String, String> query = new HashMap<String, String>();
        if(area!=null) {//截取面积字符（50-60）
            String[] areas = area.split("-");
            query.put("min_area", areas[0]);
            query.put("max_area", areas[1]);
        }
        if(price!=null) {//截取价钱字符（100-150）
            String[] prices = price.split("-");
            query.put("min_price", prices[0]);
            query.put("max_price", prices[1]);
        }
        query.put("district_id",district_id);
        query.put("type_id",type_id);

        PageHelper.startPage(pageNum, pageSize);
        List<House> homes = houseMapper.selectByQuery(query);
        return new PageInfo<>(homes);
    }


}