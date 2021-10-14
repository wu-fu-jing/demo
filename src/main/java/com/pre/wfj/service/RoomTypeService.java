package com.pre.wfj.service;

import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Room;
import com.pre.wfj.bean.RoomType;
import com.pre.wfj.mapper.RoomTypeMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class RoomTypeService {
    @Autowired
    RoomTypeMapper roomTypeMapper;


    //更新剩余数量
    public boolean updateNum(int num,String id){
        return roomTypeMapper.updateNum(num,id);
    }

    //查询所有房型
    public List<RoomType> getAll(String hotel_id){
        return roomTypeMapper.getAll( hotel_id);
    }
    //删除一个房型
    public boolean deleteone(String id){
       return   roomTypeMapper.deleteone(id);
    }

    //查询一个房型
    public RoomType getone(String name ,String hotel_id){
        return roomTypeMapper.getone( name,hotel_id);
    }

    //增加一个房型
    public boolean AddRoomType(RoomType roomType){
        String id = IdUtil.simpleUUID();
        roomType.setId(id);
        return roomTypeMapper.AddRoomType(roomType);
    }
    //更新一个房型
    public boolean updateRoomType(RoomType roomType){
        return roomTypeMapper.updateRoomType(roomType);
    }

    //前台查询一个房型
    public RoomType seletebyid(String id){
        return roomTypeMapper.seletebyid(id);
    }
}
