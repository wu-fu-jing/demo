package com.pre.wfj.controller;


import com.pre.wfj.bean.Hotel;
import com.pre.wfj.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @RequestMapping("addhotel")
    public  boolean addYh(Hotel hotel){
        System.out.println(hotel);
        return hotelService.addYh(hotel);
    }
    //删除一个酒店信息
    @RequestMapping("/deleteone")
    public boolean deleteone(String id){
        return hotelService.deleteone(id);
    }

    //更新一个酒店信息
    @RequestMapping("/updatehotel")
    public boolean updateHotel(Hotel hotel){
        System.out.println(hotel);
        return hotelService.updateHotel(hotel);
    }

    //查询到一个酒店信息
    @RequestMapping("/getone")
    public Hotel getone(String id){
        return hotelService.getone(id);
    }

    //查询出一个存在session的酒店信息
    @RequestMapping("/geonesession")
    public Hotel getonesession(String yhbh){
        return hotelService.getonesession(yhbh);
    }

    @RequestMapping("/getAll")
    //多表查询所有酒店
    public List<Hotel> getAll(){
        return hotelService.getAll();
    }

    //模糊查询酒店
    @RequestMapping("/mohu")
    public List<Hotel> mohu(String address,String name){
        return hotelService.mohu(address, name);
    }

    //通过id查询一个酒店信息
    @RequestMapping("/getOneHotel")
    public Hotel getOneHotel(String id){
        return hotelService.getOneHotel(id);
    }
}
