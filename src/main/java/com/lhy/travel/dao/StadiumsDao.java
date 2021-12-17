package com.lhy.travel.dao;

import com.lhy.travel.entity.Stadiums;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface StadiumsDao <T,K>{

//    Integer findTotals();
    List<Stadiums> findStadiums(@Param("start")Integer start, @Param("rows")Integer rows);
}