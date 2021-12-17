
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

public class Points {
    private String Club_id;
    private String Club_name;
    private String league	;
    private String chairman;
    private String Manager_name;
    private  int GP;
    private  int P;
    private int W;
    private int L;
    private int D;
    private int GS;
    private int GA;
    private  int GD;
    private int Ranking;
}
