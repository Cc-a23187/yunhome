package com.whpu.pojo;

import lombok.Data;

/**
 * @author cc
 * @create 2020-06-17-13:47
 */
@Data
public class House {
    //1.本身的房源信息
    private Integer hid;
    private Double price;
    private Double areas;
    private String title;
    private String mark;
    private String equipment;
    private String address;
    private String imgs;
    //2.关联的用户 区域 类型
    private Users users;
    private District district;
    private Type type;

}
