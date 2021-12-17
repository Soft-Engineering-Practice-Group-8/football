package com.lhy.travel.controller;

import com.lhy.travel.entity.Points;
import com.lhy.travel.service.PointsService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin
@RequestMapping(value = "/points",method = RequestMethod.GET)

public class PointsController {
    @Autowired
    private PointsService pointsService;

    @GetMapping("/findByPage")
    public Map<String,Object> findByPage(Integer page, Integer rows){
        page=page==null?1:page;
        rows=rows==null?20:rows;
        HashMap<String, Object> map = new HashMap<>();
//        分页处理
        List<Points> points=pointsService.findByPage(page,rows);
//        计算总页数
        Integer totals=pointsService.findTotals();
        Integer totalPage=totals%rows==0?totals/rows:totals/rows+1;
        map.put("points",points);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("page",page);
        return map;
    }
}
