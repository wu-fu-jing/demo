package com.pre.wfj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Component
public class Client {
    private String id;
    private String name;
    private String pwd;
    private String sex;
    private String phone;
    private String data;
    private String tx;
}


