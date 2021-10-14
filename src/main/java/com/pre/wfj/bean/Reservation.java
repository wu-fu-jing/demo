package com.pre.wfj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {
    private String id;
    private String hotel_id;
    private String name;
    private String sjh;
    private String checkin;
    private String departure;
    private String room;
    private String price;
    private String day;
    private String remark;
    private String client_id;
    private String type;
    private String number;
    private Hotel hotel;
    private String pay;
}
