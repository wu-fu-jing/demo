package com.pre.wfj.controller;


import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Room;
import com.pre.wfj.bean.RoomType;
import com.pre.wfj.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/roomtype")
public class RoomTypeControlle {

    @Autowired
    RoomTypeService roomTypeService;

    //更新剩余数量
    @RequestMapping("/updateNum")
    public boolean updateNum(int num,String id){
        return roomTypeService.updateNum(num,id);
    }

    //查询所有房型
    @RequestMapping("/getAll")
    public List<RoomType> getAll(String hotel_id){
        return roomTypeService.getAll(hotel_id);
    }
    //删除一个房型
    @RequestMapping("/deleteone")
    public boolean deleteone(String id){
        return   roomTypeService.deleteone(id);
    }


    //查询一个房型
    @RequestMapping("/getone")
    public RoomType getone(String name,String hotel_id){
        return roomTypeService.getone(name,hotel_id);
    }
    //增加一个房型
    @RequestMapping("/addRoomType")
    public boolean AddRoomType(RoomType roomType){
        return roomTypeService.AddRoomType(roomType);
    }

    //更新一个房型
    @RequestMapping("/updateRoomType")
    public boolean updateRoomType(RoomType roomType){
        return roomTypeService.updateRoomType(roomType);
    }

    //前台查询一个房型
    @RequestMapping("/seletebyid")
    public RoomType seletebyid(String id){
        return roomTypeService.seletebyid(id);
    }
}
