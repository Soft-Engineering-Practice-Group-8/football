package com.lhy.travel.service;

import com.lhy.travel.entity.Stadiums;

import java.util.List;


public interface StadiumsService {
    List<Stadiums> findStadiums(Integer page, Integer rows);
//    Integer findTotals();
}
