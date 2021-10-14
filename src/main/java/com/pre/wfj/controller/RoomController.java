package com.pre.wfj.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pre.wfj.bean.Room;
import com.pre.wfj.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;

//    查询所有房间
//    @RequestMapping("/getAll")
//    public List<Room> getAllRoom() {
//        return roomService.getAllRoom();
//    }
//    public Result<?> getAllRoom(){
//       return Result.success(roomService.getAllRoom());
//    }

    //查询一个类型的所有房间
    @RequestMapping("/selecttype")
    public List<Room> seletetype(String roomtype_id,String type){
        System.out.println(roomtype_id);
        return roomService.seletetype(roomtype_id,type);
    }

    //增加房间
    @RequestMapping("/addRoom")
    public boolean AddRoom(Room room){
        return roomService.AddRoom(room);
    }

    //联级删除房间
    @RequestMapping("/deleteLin")
    public boolean deleteLin(String roomtype_id){
        return roomService.deleteLin(roomtype_id);
    }

    //删除房间
    @PostMapping("/deleteRoom")
            public boolean deleteRoom(String number){
            return roomService.deleteRoom(number);
        }

    @RequestMapping("/getType")
    public List<Room> getType(String type){
        return roomService.getType(type);
    }

    //选择房间
    @RequestMapping("/getNumber")
    public Room getNumber(String number){
         return roomService.getNumber(number);
    }
    //更新房间信息
    @RequestMapping("/updateRoom")
    public boolean updateRoom(Room room){
        System.out.println(room);
        return roomService.updateRoom(room);
    }
    //更新房间状态
    @RequestMapping("/updateRoomtype")
    public boolean updateRoomtype(Room room){
        return roomService.updateRoomtype(room);
    }

    @RequestMapping("/getAll")
    //多表查询所有
    public  List<Room> getAll(Integer page){
        PageHelper.startPage(page,5);
        List<Room> list= roomService.getAll();
        long total = ((Page)list).getTotal();
        return list;
    }
    @RequestMapping("/getlength")
    //多表查询所有
    public  int getLength(){
        List<Room> list= roomService.getAll();
        System.out.println(list.size());
        return list.size();
    }

    //多表查询空房
    @RequestMapping("/getAllKong")
    public List<Room> getAllKong(){
        return roomService.getAllKong();
    }
}
