package com.whpu.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author cc
 * @create 2020-06-16-10:29
 */
@Data
@Table(name = "h_users")
public class Users {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer uid;
    private String name;
    private String psw;
    private String sex;
    private Date birth;
    @Column(name = "headImg") //解决转入查询mysql变成head_img
    private String headImg;
    private String role;
}
