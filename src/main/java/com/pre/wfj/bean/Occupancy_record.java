package com.pre.wfj.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Component
@JsonIgnoreProperties(value = {"handler"})
public class Occupancy_record {
    private String id;
    private String roomnumber;
    private String hotel_id;
    private String sjh;
    private String name;
    private String identity;
    private String sex;
    private String checkin;
    private String departure;
    private String day;
    private String remark;
    private String pathway;
    private String type;
    private String fine;
    private String pay;
    private Room room;
    private String deposit;
    private String fine_remark;
}
