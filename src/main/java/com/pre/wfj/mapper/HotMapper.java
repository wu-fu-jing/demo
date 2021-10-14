package com.pre.wfj.mapper;
import com.pre.wfj.bean.Hot;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface HotMapper {
    //查询所有酒店信息
    @Select("SELECT * FROM hot e,hotel j WHERE e.hotel_id = j.id")
    @Results(id = "accountMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "hotel_id", property = "hotel_id"),
            @Result(column = "hotel_id", property = "hotel", one = @One(select = "com.pre.wfj.mapper.HotelMapper.getOneHotel"))

    })
    List<Hot> getAll();
}
