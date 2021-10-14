package com.pre.wfj.service;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Reservation;
import com.pre.wfj.mapper.ReservationMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class ReservationService {
    @Autowired
    ReservationMapper reservationMapper;
    RoomService roomService;

    //添加一个预订订单
    public boolean addReservation(Reservation reservation){
        String id = IdUtil.simpleUUID();
        reservation.setId(id);
        Date date1 = DateUtil.parse(reservation.getCheckin());
        Date date2 = DateUtil.parse(reservation.getDeparture());
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        reservation.setDay(betweenDay+"");
        reservation.setType("未入住");
        return reservationMapper.addReservation(reservation);
   }

    public List<Reservation> getAll(String type, String hotel_id){
        return reservationMapper.getAll(type,hotel_id);
    }
    //取消订单
   public  boolean updateone(String type ,String id){
        return reservationMapper.updateone(type,id);
   }
    //删除一个订单
    public boolean deleteone(String id){
        return reservationMapper.deleteone(id);
    }

    //查询一个用户的预订订单
    public List<Reservation> getAllById(String client_id ,String type){
        return reservationMapper.getAllById(client_id,type);
    }


    //查询一个用户的所有订单
    public List<Reservation> seleteAllById(String client_id){
        return reservationMapper.seleteAllById(client_id);
    }
}
