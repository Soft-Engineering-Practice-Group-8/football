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
public class Stadiums {
    private String stadium_id;
    private String stadium_name;
    private String city;
    private String Club_id;
    private String Club_name;
    private int CY;
}
