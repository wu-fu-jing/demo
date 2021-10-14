package com.pre.wfj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;


@NoArgsConstructor     //无参构造器
@AllArgsConstructor     //有参构造器
@ToString //生成tostring
@Data //生成get set
@Component
public class YHB {
    private String yhbh;
    private String pwd;
    private  String sjh;
    private  String name;
    private  String type;
    private  String username;
    private  String sex;
    private  String iskong;
    private  String hotel_id;
}
