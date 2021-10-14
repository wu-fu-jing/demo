package com.pre.wfj.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = {"handler"})
public class RoomType {
    private String id;
    private String name;
    private String imgs;
    private String price;
    private String hotel_id;
    private int num;
}
