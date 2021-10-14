package com.pre.wfj.controller;


import com.pre.wfj.bean.Reservation;
import com.pre.wfj.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;



    //添加一个预订订单
    @RequestMapping("/addRervation")
    public boolean addReservation(Reservation reservation){
       return reservationService.addReservation(reservation);
    }

    @RequestMapping("/getAll")
    public List<Reservation> getAll(String type, String hotel_id){
        return reservationService.getAll(type,hotel_id);
    }

    //取消订单
    @RequestMapping("/updateone")
    public boolean updateone(String type ,String id){
        return reservationService.updateone(type,id);
    }
    //删除一个订单
    @RequestMapping("/deleteone")
    public boolean deleteone(String id){
        return reservationService.deleteone(id);
    }

    //查询一个用户的预订订单
    @RequestMapping("/getAllById")
    public List<Reservation> getAllById(String client_id,String type ){
        return reservationService.getAllById(client_id,type);
    }


    //查询一个用户的所有订单
    @RequestMapping("/seleteAllById")
    public List<Reservation> seleteAllById(String client_id){
        return reservationService.seleteAllById(client_id);
    }
}

