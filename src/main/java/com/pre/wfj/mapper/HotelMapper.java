package com.pre.wfj.mapper;

import com.pre.wfj.bean.Hotel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HotelMapper {
    //添加用户
    @Insert("INSERT INTO hotel(  id,phone,picture,address,leaves,name,kind,star,price,synopsis,yhbh,data) VALUES(#{id},#{phone},#{picture},#{address},#{leaves},#{name},#{kind},#{star},#{price},#{synopsis},#{yhbh},#{data})")
    boolean addYh(Hotel hotel);

    //更新一个酒店信息
    @Update("UPDATE hotel set  phone=#{phone},leaves=#{leaves},address=#{address},picture=#{picture},name=#{name},kind=#{kind},star=#{star},price=#{price},synopsis =#{synopsis},data =#{data}   WHERE id=#{id}")
    boolean updateHotel(Hotel hotel);

    //删除一个酒店信息

    @Delete("DELETE FROM hotel WHERE id = #{id}")
    boolean deleteone(String id);

    //查询所有酒店信息
    @Select("SELECT * FROM hotel e,yhb j WHERE e.yhbh = j.yhbh")
    @Results(id="accountMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "leaves",property = "leaves"),
            @Result(column = "address",property = "address"),
            @Result(column = "picture",property = "picture"),
            @Result(column = "name",property = "name"),
            @Result(column = "kind",property = "kind"),
            @Result(column = "star",property = "star"),
            @Result(column = "price",property = "price"),
            @Result(column = "synopsis",property = "synopsis"),
            @Result(column = "data",property = "data"),
            @Result(column = "yhbh",property = "yhbh"),
            @Result(column = "yhbh",property = "yhb",one = @One(select = "com.pre.wfj.mapper.YHBMapper.seletebyid"))

    })
    List<Hotel> getAll();

    //查询出一个存在session的酒店信息
    @Select("SELECT  phone,leaves,id,address,picture,name,kind,star,price,synopsis,yhbh,data FROM hotel WHERE yhbh = #{yhbh}    " )
    Hotel getonesession(String yhbh);

    //查询出一个酒店信息
    @Select("SELECT  phone,leaves,id,address,picture,name,kind,star,price,synopsis,yhbh,data FROM hotel WHERE id = #{id}    " )
    Hotel getOneHotel(String id);

      //模糊查询酒店
//    @SelectProvider(type = HotelProvider.class,method = "getListSql" )
//    List<Hotel> mohu(Hotel hotel);

    //通过名字和地址查询酒店
    @Select("SELECT  phone,leaves,id,address,picture,name,kind,star,price,synopsis,yhbh,data FROM hotel WHERE address LIKE '%${address}%' OR name LIKE '%${name}%' " )
    List<Hotel> mohu(String address,String name);


    //查询一个酒店信息

    @Select("SELECT * FROM hotel e,yhb j WHERE e.yhbh = j.yhbh and e.id=#{id}")
    @Results(id="accountMaps",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "leaves",property = "leaves"),
            @Result(column = "address",property = "address"),
            @Result(column = "picture",property = "picture"),
            @Result(column = "name",property = "name"),
            @Result(column = "kind",property = "kind"),
            @Result(column = "star",property = "star"),
            @Result(column = "price",property = "price"),
            @Result(column = "synopsis",property = "synopsis"),
            @Result(column = "data",property = "data"),
            @Result(column = "yhbh",property = "yhbh"),
            @Result(column = "yhbh",property = "yhb",one = @One(select = "com.pre.wfj.mapper.YHBMapper.seletebyid"))

    })
    Hotel getone(String id);
}
