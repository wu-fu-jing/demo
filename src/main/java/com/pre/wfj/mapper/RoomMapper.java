package com.pre.wfj.mapper;


import com.pre.wfj.bean.Room;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface RoomMapper {

    //查询一个类型的所有房间
    @Select("select type,roomtype_id,number from room where roomtype_id=#{roomtype_id} AND type=#{type}")
    List<Room> seletetype(String roomtype_id,String type);


    //联级删除房间
    @Delete("DELETE FROM room WHERE roomtype_id=#{roomtype_id}")
    boolean deleteLin(String roomtype_id);

    //删除一个房间
    @Delete("DELETE FROM room WHERE number=#{number}")
     boolean deleteRoom(String number);
    //增加一个房间
    @Insert("INSERT INTO room(number,type,roomtype_id) VALUES(#{number},#{type},#{roomtype_id})")
     boolean AddRoom(Room room);

    //更新房间状态
    @Update("UPDATE  room set type=#{type}  WHERE number=#{number}")
    boolean updateRoomtype(Room room);

    //更新一个房间
    @Update("UPDATE  room set roomtype_id=#{roomtype_id}  WHERE number=#{number}")
    boolean updateRoom(Room room);

    @Select("SELECT number,type,price,name,picture FROM room ")
     List<Room> getAllRoom();

    @Select("select number,type,price,name from room where type= #{type}")
     List<Room> getType(String type);

    @Select("select number,type,roomtype_id from room where number= #{number}")
    Room getNumber(String number);

    //多表查询
    @Select("SELECT * FROM room e,roomtype j WHERE e.roomtype_id = j.id")
    @Results(id="accountMap",value = {
            @Result(column = "number",property = "number"),
            @Result(column = "type",property = "type"),
            @Result(column = "roomtype_id",property = "roomtype_id"),
            @Result(column = "roomtype_id",property = "roomType",one = @One(select = "com.pre.wfj.mapper.RoomTypeMapper.seletebyid"))

    })
    
    List<Room> getAll();

    //查询一个房间信息
    @Select("SELECT * FROM room e,roomtype j WHERE e.roomtype_id = j.id and number=#{number}")
    @Results(id="accountMap3",value = {
            @Result(column = "number",property = "number"),
            @Result(column = "type",property = "type"),
            @Result(column = "roomtype_id",property = "roomtype_id"),
            @Result(column = "roomtype_id",property = "roomType",one = @One(select = "com.pre.wfj.mapper.RoomTypeMapper.seletebyid"
            ,fetchType = FetchType.LAZY)
            )

    })
//    @Result(column = "roomtype_id",property = "roomType",many
//            = @Many(select = "com.pre.wfj.mapper.RoomTypeMapper.seletebyid"
//    )
    Room getone();

    //多表查询
    @Select("SELECT * FROM room e,roomtype j WHERE e.roomtype_id = j.id and e.type='空房'" )
    @Results(id="accountMap2",value = {
            @Result(column = "number",property = "number"),
            @Result(column = "type",property = "type"),
            @Result(column = "roomtype_id",property = "roomtype_id"),
            @Result(column = "roomtype_id",property = "roomType",one = @One(select = "com.pre.wfj.mapper.RoomTypeMapper.seletebyid"))

    })

    List<Room> getAllKong();
}
