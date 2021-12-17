package com.lhy.travel.controller;

import com.lhy.travel.entity.Player;
import com.lhy.travel.entity.Result;
import com.lhy.travel.service.PlayerService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ResponseBody
@RestController
//@CrossOrigin
@RequestMapping("/players")

public class PlayerController {
    @Autowired
    private PlayerService playerService;


    @PostMapping("update")
    public Result update(@RequestBody Player player)
    {
        Result result=new Result();
        try {
            playerService.update(player);
            result.setMsg("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    @GetMapping("findOne")
    public Player findOne(String Player_id){
        return playerService.findOne(Player_id);
    }

    @GetMapping("delete")
    public  Result delete(String Player_id){
        Result result = new Result();
        try {
            playerService.delete(Player_id);
            result.setMsg("删除球员成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg("删除失败");
        }
        return  result;
    }


    @PostMapping("save")
    public Result save(@RequestBody Player player){
        Result result = new Result();
        try {
            playerService.save(player);
            result.setMsg("保存球员信息成功");
        }catch(Exception e){
            e.printStackTrace();
            result.setState(false).setMsg("保存球员信息失败");
        }
        return result;
    }

    @GetMapping("/findPlayers")
    public Map<String,Object> findPlayers(Integer page, Integer rows){
        page=page==null?1:page;
        rows=rows==null?20:rows;
        HashMap<String, Object> map = new HashMap<>();
//        分页处理
        List<Player> players=playerService.findPlayers(page,rows);
//        计算总页数
        Integer totals=playerService.findTotals();
        Integer totalPage=totals%rows==0?totals/rows:totals/rows+1;
        map.put("players",players);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("page",page);
        return map;
    }

    @GetMapping("/findAss")
    public Map<String,Object> findAss(Integer page, Integer rows){
        page=page==null?1:page;
        rows=rows==null?1000:rows;
        HashMap<String, Object> map = new HashMap<>();
//        分页处理
        List<Player> ass=playerService.findAss(page,rows);
//        计算总页数
        Integer totals=playerService.findTotals();
        Integer totalPage=totals%rows==0?totals/rows:totals/rows+1;
        map.put("players",ass);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("page",page);
        return map;
    }
}
