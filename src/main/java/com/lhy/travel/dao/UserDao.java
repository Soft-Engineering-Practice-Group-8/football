package com.lhy.travel.dao;

import com.lhy.travel.entity.User;
import com.lhy.travel.entity.Result;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    // 根据用户名查询用户
    User findByUsername(String username);
}
