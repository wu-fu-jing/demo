package com.pre.wfj.mapper;

import com.pre.wfj.bean.YHB;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper  //第一种方式引用mapper
public interface YHBMapper {

    //删除一个用户
    @Delete("DELETE FROM yhb WHERE yhbh = #{yhbh}")
    boolean deleteone(String yhbh);

    //查询所有用户
    @Select("SELECT yhbh,sjh,pwd,name,type,username,sex,iskong FROM yhb WHERE username!='admin' and type=#{type} order by iskong")
    List<YHB>  getAll(String type);

    //添加用户
    @Insert("INSERT INTO yhb(yhbh,sjh,pwd,name,type,username,sex,iskong) VALUES(#{yhbh},#{sjh},#{pwd},#{name},#{type},#{username},#{sex},iskong=#{iskong})")
    boolean addYh(YHB yhb);

    //更新是否已经管理酒店
    @Update("UPDATE  yhb set iskong=#{iskong} WHERE yhbh=#{yhbh}")
    boolean updateIskong(String iskong ,String yhbh);

    //登录
    @Select("SELECT yhbh,sjh,pwd,name,type,username,sex,iskong FROM yhb WHERE username=#{username} and pwd=#{pwd}")
    YHB getYh(String username,String pwd);


    //通过名字查询一个用户
    @Select("SELECT yhbh,sjh,pwd,name,type,username,sex,iskong FROM yhb WHERE name=#{name}")
    YHB seleteone(String name);

    //通过用户名查询一个用户
    @Select("SELECT yhbh,sjh,pwd,name,type,username,sex,iskong FROM yhb WHERE username=#{username}")
    YHB seleteousername(String username);

    //多表查询时用到的
    @Select("SELECT yhbh,sjh,pwd,name,type,username,sex FROM yhb WHERE yhbh=#{yhbh}")
    YHB seletebyid(String yhbh);

    //修改密码
    @Update("UPDATE  yhb set pwd=#{pwd} WHERE yhbh=#{yhbh}")
    boolean updatePwd(String pwd,String yhbh);

    //更新用户
    @Update("UPDATE  yhb set name=#{name}, username =#{username},sex=#{sex},sjh=#{sjh} WHERE yhbh=#{yhbh}")
    boolean updateYh(YHB yhb);



    //员工管理

    //添加员工
    @Insert("INSERT INTO yhb(yhbh,sjh,pwd,name,type,username,sex,hotel_id,iskong) VALUES(#{yhbh},#{sjh},#{pwd},#{name},#{type},#{username},#{sex},hotel_id=#{hotel_id},iskong=#{iskong})")
    boolean addyuangong(YHB yhb);

    //查询所有员工
    @Select("SELECT yhbh,sjh,pwd,name,type,username,sex,iskong FROM yhb WHERE username!='admin' and type=#{type} and hotel_id=#{hotel_id} order by iskong")
    List<YHB>  getAllyuangong(String type,String hotel_id);

}
