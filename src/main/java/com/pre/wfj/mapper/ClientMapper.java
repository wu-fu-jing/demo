package com.pre.wfj.mapper;


import com.pre.wfj.bean.Client;
import com.pre.wfj.bean.Riqi;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClientMapper {

    //删除一个客户
    @Delete("DELETE FROM client WHERE id=#{id}")
    boolean deleteone(String id);

    //查询所有客户
    @Select("SELECT id,name,data,pwd,sex,phone,tx FROM client order by data")
    List<Client>  getAll();

    //查询注册用户趋势
    @Select("SELECT data,COUNT(data) As 'day' from client group by data order by DATA LIMIT 7")
    List<Riqi>  getqushi();

    @Select("SELECT id,name,data,pwd,sex,phone FROM client WHERE phone=#{phone} and pwd=#{pwd}")
    Client login(String phone,String pwd);


    //查找用户是否已经被注册
    @Select("SELECT id,name,data,pwd,sex,phone FROM client WHERE phone=#{phone}")
    Client register(String phone);

    @Update("UPDATE client set pwd=#{pwd} WHERE id=#{id}")
    boolean updatePwd(String pwd,String id);

    @Insert("INSERT INTO client(id,name,sex,phone,pwd,data,tx) VALUES(#{id},#{name},#{sex},#{phone},#{pwd},#{data},#{tx})")
    boolean addClient(Client client);
}
