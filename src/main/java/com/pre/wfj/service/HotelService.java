package com.pre.wfj.service;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Hotel;
import com.pre.wfj.bean.YHB;
import com.pre.wfj.mapper.HotelMapper;
import com.pre.wfj.mapper.YHBMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class HotelService {

    @Autowired
    HotelMapper hotelMapper;
    YHBMapper yhbMapper;
    //添加一个酒店信息
   public  boolean addYh(Hotel hotel){
       String simpleUUID = IdUtil.simpleUUID();
       String today= DateUtil.today();
       hotel.setId(simpleUUID);
       hotel.setData(today);
       return hotelMapper.addYh(hotel);
    }
    //删除一个酒店信息
    public boolean deleteone(String id){
       return hotelMapper.deleteone(id);
    }
    //更新一个酒店信息
    public boolean updateHotel(Hotel hotel){
       return hotelMapper.updateHotel(hotel);
    }
    //查询到一个酒店信息
    public Hotel getone(String id){
       return hotelMapper.getone(id);
    }

    //通过id查询一个酒店信息
    public Hotel getOneHotel(String id){
       return hotelMapper.getOneHotel(id);
    }

    //查询出一个存在session的酒店信息
    public Hotel getonesession(String yhbh){
        return hotelMapper.getonesession(yhbh);
    }

    //模糊查询酒店
    public List<Hotel> mohu(String address,String name){
       return hotelMapper.mohu(address, name);
    }

    //多表查询所有酒店
    public List<Hotel> getAll(){
       return hotelMapper.getAll();
    }
}
