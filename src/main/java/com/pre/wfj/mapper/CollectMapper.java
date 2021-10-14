package com.pre.wfj.mapper;


import com.pre.wfj.bean.Collect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectMapper {
//    删除一个收藏
    @Delete("DELETE FROM collect WHERE hotel_id=#{hotel_id} AND client_id=#{client_id}")
    boolean deleteone(String hotel_id,String client_id);
//    增加一个收藏
    @Insert("INSERT INTO collect(id,hotel_id,client_id) VALUES(#{id},#{hotel_id},#{client_id})")
    boolean addCollect(Collect collect);

    //查询出所有收藏
    //多表查询
    @Select("SELECT * FROM collect e,hotel j WHERE e.hotel_id = j.id AND e.client_id=#{client_id}")
    @Results(id="accountMap",value = {
            @Result(column = "hotel_id",property = "hotel_id"),
            @Result(column = "hotel_id",property = "hotel",one = @One(select = "com.pre.wfj.mapper.HotelMapper.getOneHotel"))

    })
    List<Collect> getCollect(String client_id);

    //查询一个收藏
    @Select("SELECT  id,hotel_id,client_id FROM collect WHERE hotel_id=#{hotel_id} and client_id = #{client_id}" )
    Collect getone(String hotel_id,String client_id);
}
