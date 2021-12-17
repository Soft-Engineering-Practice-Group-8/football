package com.lhy.travels.test;

import com.lhy.travel.FootballApplication;
import com.lhy.travel.entity.Points;
import com.lhy.travel.service.PointsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = FootballApplication.class)
@RunWith(SpringRunner.class)
public class TestPoints {

    @Autowired
    private PointsService pointsService;
    @Test
    public void testFindByPage(){
        List<Points> list= pointsService.findByPage(1,5);
        list.forEach(pr->{
            System.out.println(pr);
        });
    }
}
