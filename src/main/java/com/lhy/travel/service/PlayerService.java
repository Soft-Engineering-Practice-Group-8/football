package com.lhy.travel.service;

import com.lhy.travel.entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> findPlayers(Integer page, Integer rows);
    List<Player> findAss(Integer page, Integer rows);
    Integer findTotals();
    void save(Player player);
    void delete(String Player_id);
    Player findOne(String Player_id);
    void update(Player player);
}
