package com.pre.wfj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
@Data
@JsonIgnoreProperties(value = {"handler"})
public class Room {
    private String number;
    private String type;
    private String roomtype_id;
    private RoomType roomType;
}
