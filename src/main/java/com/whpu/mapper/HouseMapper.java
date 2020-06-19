package com.whpu.mapper;

import com.whpu.mapper.provider.HouseProvider;
import com.whpu.pojo.House;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author cc
 * @create 2020-06-17-13:46
 */
public interface HouseMapper  {
    //全关联查询
    @Select("select h.*,u.*,d.*,t.* from h_house h ,h_district d,h_type t,h_users u where h.user_id=u.uid and h.district_id=d.did and h.type_id=t.typeid")
    @Results(id = "houseMap",value ={
            //users表
            @Result(column = "uid",property = "users.uid"),
            @Result(column = "name",property = "users.name"),
            @Result(column = "psw",property = "users.psw"),
            @Result(column = "psw",property = "users.psw"),
            @Result(column = "sex",property = "users.sex"),
            @Result(column = "birth",property = "users.birth"),
            @Result(column = "headImg",property = "users.headImg"),
            @Result(column = "role",property = "users.role"),
            //district表
            @Result(column = "did",property = "district.did"),
            @Result(column = "parentid",property = "district.parentId"),
            @Result(column = "dis_name",property = "district.disName"),
            //type表
            @Result(column = "typeid",property = "type.typeid"),
            @Result(column = "typedesc",property = "type.typedesc"),
    })
    List<House> getHouse();

    @Insert("insert into h_house values (null,#{user_id},#{district_id},#{type_id},#{price},#{areas}" +
            ",#{title},#{mark},#{equipment},#{address},#{imgs})")
    void addHouse(House house);

    /*@Delete("delete from h_house where hid = #{hid}")
    void deleteHouse(House house);*/
    //条件查询
    @SelectProvider(type = HouseProvider.class,method = "selectByQuery")
    @ResultMap("houseMap")//引用上面的 @Results
    List<House> selectByQuery(Map<String, String> query);
}
