package com.pre.wfj.mapper;

import com.pre.wfj.bean.Evaluate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvaluateMapper {
    //增加一条评论
    @Insert("INSERT INTO evaluate(id,content,reservation_id,score,hotel_id) VALUES(#{id},#{content},#{reservation_id},#{score},#{hotel_id})")
    boolean addEvaluate(Evaluate evaluate);

    //查询所有评论
    @Select("SELECT * FROM evaluate e,reservation j WHERE e.reservation_id = j.id and e.hotel_id=#{hotel_id}")
    @Results(id="accountMap",value = {
            @Result(column = "hotel_id",property = "hotel_id"),
            @Result(column = "reservation_id",property = "reservation_id"),
            @Result(column = "reservation_id",property = "reservation",one = @One(select = "com.pre.wfj.mapper.ReservationMapper.getoneByid"
            )
            )

    })
    List<Evaluate> getAll(String hotel_id);
}
