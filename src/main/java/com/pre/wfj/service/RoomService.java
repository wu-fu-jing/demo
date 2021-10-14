package com.pre.wfj.service;


import com.pre.wfj.bean.Room;
import com.pre.wfj.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class RoomService {
    @Autowired
    RoomMapper roomMapper;
    public List<Room> getAllRoom(){
        return roomMapper.getAllRoom();
    }

    //查询一个类型的所有房间
    public List<Room> seletetype(String roomtype_id,String type){
        return roomMapper.seletetype(roomtype_id,type);
    }

    //联级删除房间
    public boolean deleteLin(String roomtype_id){
        return roomMapper.deleteLin(roomtype_id);
    }

    // 增加
    public boolean AddRoom(Room room){
        room.setType("空房");
        return roomMapper.AddRoom(room);
    }

    public boolean deleteRoom(String number){
        return roomMapper.deleteRoom(number);
    }

    public List<Room> getType(String type){
        return roomMapper.getType(type);
    }

    public  Room getNumber(String number){
        return roomMapper.getNumber(number);
    }
    // 更新
    public boolean updateRoom(Room room){
        return roomMapper.updateRoom(room);
    }

    //更新房间状态
    public boolean updateRoomtype(Room room){
        return roomMapper.updateRoomtype(room);
    }

    //多表查询所有
    public  List<Room> getAll(){
        return roomMapper.getAll();
    }
    //多表查询空房
    public List<Room> getAllKong(){
        return roomMapper.getAllKong();
    }

}
