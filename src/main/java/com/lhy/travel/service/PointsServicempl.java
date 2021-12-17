package com.lhy.travel.service;

import com.lhy.travel.dao.PointsDao;
import com.lhy.travel.entity.Points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PointsServicempl implements PointsService{
    @Autowired
    private PointsDao pointsDao;

    @Override
    public List<Points> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return pointsDao.findByPage(start,rows);
    }

    @Override
    public Integer findTotals() {
        return pointsDao.findTotals();
    }
}
