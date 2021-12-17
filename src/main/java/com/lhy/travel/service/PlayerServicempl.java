package com.lhy.travel.service;

import com.lhy.travel.dao.PlayerDao;
import com.lhy.travel.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServicempl implements PlayerService{
    @Autowired
    private PlayerDao playerDao;

    @Override
    public List findPlayers(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return playerDao.findPlayers(start,rows);
    }

    @Override
    public void delete(String Player_id){
        playerDao.delete(Player_id);
    }

    @Override
    public Player findOne(String Player_id)
    {
        return playerDao.findOne(Player_id);
    }

    @Override
    public void update(Player player) {
        playerDao.update(player);
    }

    @Override
    public  void save(Player player){
        playerDao.save(player);
    }

    @Override
    public Integer findTotals() {
        return playerDao.findTotals();
    }

    @Override
    public List findAss(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return playerDao.findAss(start,rows);
    }
}
