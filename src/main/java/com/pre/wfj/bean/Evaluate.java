package com.pre.wfj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Evaluate {
    private  String id;
    private  String content;
    private  String reservation_id;
    private  String score;
    private  String hotel_id;
    private  Reservation reservation;
}
