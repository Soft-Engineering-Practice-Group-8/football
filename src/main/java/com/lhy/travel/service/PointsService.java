package com.lhy.travel.service;

import com.lhy.travel.entity.Points;

import java.util.List;

public interface PointsService {

    List<Points> findByPage(Integer page,Integer rows);
    Integer findTotals();
}
