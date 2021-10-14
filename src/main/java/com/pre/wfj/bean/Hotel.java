package com.pre.wfj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Component

public class Hotel {
    private  String id;
    private  String picture;
    private  String address;
    private  String leaves;
    private  String name;
    private  String kind;
    private  String star;
    private  String price;
    private  String synopsis;
    private  String yhbh;
    private  String data;
    private  String phone;
    private  YHB yhb;


}
