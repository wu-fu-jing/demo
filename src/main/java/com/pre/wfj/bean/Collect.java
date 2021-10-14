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
public class Collect {
    private String id;
    private String hotel_id;
    private String client_id;
    private Hotel hotel;
}
