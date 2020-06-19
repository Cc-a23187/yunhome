package com.whpu.mapper;

import com.whpu.pojo.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cc
 * @create 2020-06-19-10:31
 */
public interface TypeMapper {
    @Select("select * from h_type")
    List<Type> selectAll();
}
