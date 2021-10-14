package com.pre.wfj.controller;


import com.pre.wfj.bean.Occupancy_record;
import com.pre.wfj.service.Occupancy_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/occupancy")
public class Occupancy_recordController {
    @Autowired
    Occupancy_recordService occupancy_recordService;

    //删除一个开房记录
    @RequestMapping("/deletone")
    public boolean deleteone(String id){
        return occupancy_recordService.deleteone(id);
    }

    //增加一个开房记录
    @RequestMapping("/addOccupancy")
    public boolean AddOccupancy(Occupancy_record occupancy_record){
        return occupancy_recordService.AddOccupancy(occupancy_record);
    }

    //退房更新
    @RequestMapping("/updateoccupancy")
    public boolean updateOccupancy(Occupancy_record occupancy_record){
        System.out.println(occupancy_record);
        return occupancy_recordService.updateOccupancy(occupancy_record);
    }

    //续住更新
    @RequestMapping("/updatexuoccupancy")
    public boolean updateXuOccupancy(Occupancy_record occupancy_record){
        return occupancy_recordService.updateXuOccupancy(occupancy_record);
    }

    //查询开房记录
    @RequestMapping("/getAll")
    public List<Occupancy_record> getAll(String type,String hotel_id){
        return occupancy_recordService.getAll(type,hotel_id);
    }
}
