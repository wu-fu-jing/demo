package com.pre.wfj.mapper;


import com.pre.wfj.bean.Reservation;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface ReservationMapper {
    //添加预订订单
    @Insert("INSERT INTO reservation(id,client_id,hotel_id,name,sjh,checkin,departure,room,price,day,remark,type,number,pay) VALUES(#{id},#{client_id},#{hotel_id},#{name},#{sjh},#{checkin},#{departure},#{room},#{price},#{day},#{remark},#{type},#{number},#{pay})")
    boolean addReservation(Reservation reservation);

    //查询所有预订订单
    @Select("SELECT  id,hotel_id,name,sjh,checkin,departure,room,price,day,remark,client_id,type,number,pay  FROM reservation where type=#{type} and hotel_id=#{hotel_id}" )
    List<Reservation> getAll(String type, String hotel_id);

    //取消订单
    @Update("UPDATE  reservation set type=#{type}  WHERE id=#{id}")
    boolean updateone(String type ,String id);

    //删除一个订单
    @Delete("DELETE FROM   reservation WHERE id = #{id}")
    boolean deleteone(String id);

   // 查询一个用户的预订订单
   @Select("SELECT * FROM reservation e,hotel j WHERE e.hotel_id = j.id and client_id=#{client_id}")
   @Results(id="accountMap",value = {
           @Result(column = "hotel_id",property = "hotel_id"),
           @Result(column = "hotel_id",property = "hotel",one = @One(select = "com.pre.wfj.mapper.HotelMapper.getOneHotel"
                   )
           )

   })
    List<Reservation> seleteAllById(String client_id);

    //查询所有预订订单（未出行和未评价）
    @Select("SELECT * FROM reservation e,hotel j WHERE e.hotel_id = j.id and client_id=#{client_id} and type=#{type}")
    @Results(id="accountMap2",value = {
            @Result(column = "hotel_id",property = "hotel_id"),
            @Result(column = "hotel_id",property = "hotel",one = @One(select = "com.pre.wfj.mapper.HotelMapper.getOneHotel"
            )
            )

    })
    List<Reservation> getAllById(String client_id ,String type);

    //通过id查询一个订单
    @Select("SELECT  id,hotel_id,name,sjh,checkin,departure,room,price,day,remark,client_id,type,number,pay FROM reservation where id=#{id}" )
    Reservation getoneByid(String id);
}
