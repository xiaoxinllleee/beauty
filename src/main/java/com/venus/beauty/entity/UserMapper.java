package com.venus.beauty.entity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{name}")
    User findByName(@Param("name") String name);

    @Select("select * from user")
    List<User> queryAllUser();
}
