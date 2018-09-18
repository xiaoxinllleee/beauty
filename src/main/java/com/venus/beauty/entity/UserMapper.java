package com.venus.beauty.entity;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /*@Select("SELECT * FROM user WHERE username = #{name}")
    User findByName(@Param("name") String name);

    @Select("select * from user")
    List<User> queryAllUser();*/
}
