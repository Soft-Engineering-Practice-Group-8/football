package com.lhy.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)

public class Player {
    private String Player_id;
    private String Player_name;
    private String Player_number;
    private String Player_nation;
    private String Player_age;
    private String Club_id;
    private String Club_name;
    private String Player_position;
    private int height;
    private int weight;
    private int worth;
    private int actions;
    private int ActAsSub;
    private int FGs;
    private int Asts;
    private int RC;
    private int YC;

}
