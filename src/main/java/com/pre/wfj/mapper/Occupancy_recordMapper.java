package com.pre.wfj.mapper;

import com.pre.wfj.bean.Occupancy_record;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Occupancy_recordMapper {
    //增加一个开房记录
    @Insert("INSERT INTO occupancy_record(id,deposit,roomnumber,hotel_id,sjh,name,identity,sex,checkin,departure,day,remark,pathway,type,fine,pay,fine_remark) " +
            "VALUES(#{id},#{deposit},#{roomnumber},#{hotel_id},#{sjh},#{name},#{identity},#{sex},#{checkin},#{departure},#{day},#{remark},#{pathway},#{type},#{fine},#{pay},#{fine_remark})")
    boolean AddOccupancy(Occupancy_record occupancy_record);

    //续住更新
    @Update("UPDATE  occupancy_record  set departure=#{departure},pay=#{pay},day=#{day}  WHERE id=#{id}")
    boolean updateXuOccupancy(Occupancy_record occupancy_record);

    //退房更新
    @Update("UPDATE  occupancy_record  set fine=#{fine},fine_remark=#{fine_remark},pay=#{pay},type=#{type},departure=#{departure}  WHERE id=#{id}")
    boolean updateOccupancy(Occupancy_record occupancy_record);

    //查询开房记录
    @Select("SELECT * FROM occupancy_record a,room b,roomtype c WHERE a.roomnumber = b.number AND b.roomtype_id = c.id AND a.type=#{type} And a.hotel_id=#{hotel_id} ORDER BY a.departure DESC"  )
    @Results(id="accountMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "roomnumber",property = "roomnumber"),
            @Result(column = "hotel_id",property = "hotel_id"),
            @Result(column = "sjh",property = "sjh"),
            @Result(column = "name",property = "name"),
            @Result(column = "identity",property = "identity"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "checkin",property = "checkin"),
            @Result(column = "departure",property = "departure"),
            @Result(column = "day",property = "day"),
            @Result(column = "remark",property = "remark"),
            @Result(column = "pathway",property = "pathway"),
            @Result(column = "fine",property = "fine"),
            @Result(column = "pay",property = "pay"),
            @Result(column = "type",property = "type"),
            @Result(column = "deposit",property = "deposit"),
            @Result(column = "fine_remark",property = "fine_remark"),
            @Result(column = "roomnumber",property = "room",one = @One(select = "com.pre.wfj.mapper.RoomMapper.getone"))

    })

    List<Occupancy_record> getAll(String type,String hotel_id);

    //删除一个开房记录
    @Delete("DELETE FROM  occupancy_record WHERE id = #{id}")
    boolean deleteone(String id);

}
