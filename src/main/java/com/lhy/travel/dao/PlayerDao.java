package com.lhy.travel.dao;

import com.lhy.travel.entity.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface PlayerDao <T,K>{

    void save(T t);
    void update(T t);
    void delete(K k);
    List<T> findAll();
    Player findOne(K k);
    Integer findTotals();
    List<Player> findPlayers(@Param("start")Integer start, @Param("rows")Integer rows);
    List<Player> findAss(@Param("start")Integer start, @Param("rows")Integer rows);
}
