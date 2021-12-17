package com.lhy.travel.dao;

import com.lhy.travel.entity.Player;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao <T,K>{

    void save(T t);
    void update(T t);
    void delete(T t);
    List<T> findAll();
    List<T> findByPage(@Param("start")Integer start,@Param("rows")Integer rows);
    Integer findTotals();
    List<Player> findPlayers(@Param("start")Integer start, @Param("rows")Integer rows);
}
