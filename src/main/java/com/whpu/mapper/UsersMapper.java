package com.whpu.mapper;

import com.whpu.pojo.Users;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author cc
 * @create 2020-06-16-10:56
 */

public interface UsersMapper {
    @Select("select * from h_users")
    List<Users> getAllUsers();

}
