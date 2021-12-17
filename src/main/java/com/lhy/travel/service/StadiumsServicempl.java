package com.lhy.travel.service;

import com.lhy.travel.dao.StadiumsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StadiumsServicempl implements StadiumsService{
    @Autowired
    private StadiumsDao stadiumsDao;

    @Override
    public List findStadiums(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return stadiumsDao.findStadiums(start,rows);
    }
}
