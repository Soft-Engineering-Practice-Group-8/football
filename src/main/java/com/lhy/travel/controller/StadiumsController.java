package com.lhy.travel.controller;

import com.lhy.travel.entity.Points;
import com.lhy.travel.entity.Stadiums;
import com.lhy.travel.service.StadiumsService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin
@RequestMapping(value = "/stadiums",method = RequestMethod.GET)

public class StadiumsController {
    @Autowired
    private StadiumsService stadiumsService;

    @GetMapping("/findStadiums")
    public Map<String,Object> findStadiums(Integer page, Integer rows){
        page=page==null?1:page;
        rows=rows==null?20:rows;
        HashMap<String, Object> map = new HashMap<>();
//        分页处理
        List<Stadiums> stadiums=stadiumsService.findStadiums(page,rows);
//        计算总页数
        map.put("stadiums",stadiums);
        map.put("page",page);
        return map;
    }
}
