package com.pre.wfj.mapper;

import com.pre.wfj.bean.RoomType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper 
public interface RoomTypeMapper {

    //更新剩余数量
    @Update("UPDATE  roomtype set num=#{num} WHERE id=#{id}")
    boolean updateNum(int num,String id);

    //查询所有房间类型
    @Select("SELECT id,name,price,imgs,hotel_id,num FROM roomtype where hotel_id=#{hotel_id} ")
    List<RoomType> getAll(String hotel_id);

    //后台查询一个类型
    @Select("SELECT id,name,price,imgs,hotel_id,num FROM roomtype  where name=#{name} and hotel_id=#{hotel_id}")
    RoomType getone(String name,String hotel_id);

    //删除一个房型
    @Delete("DELETE FROM roomtype WHERE id=#{id}")
    boolean deleteone(String id);

    //增加一个房型
    @Insert("INSERT INTO roomtype(id,name,imgs,price,hotel_id,num) VALUES(#{id},#{name},#{imgs},#{price},#{hotel_id},#{num})")
    boolean AddRoomType(RoomType roomType);
    //更新一个房型
    @Update("UPDATE  roomtype set name=#{name}, price =#{price},imgs =#{imgs} WHERE id=#{id}")
    boolean updateRoomType(RoomType roomType);
    //查询一个房型
    @Select("SELECT id,name,price,imgs,hotel_id,num FROM roomtype  where id=#{id}")
    RoomType seletebyid(String id);
}
