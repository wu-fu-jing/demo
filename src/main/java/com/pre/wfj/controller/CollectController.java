package com.pre.wfj.controller;

import com.github.pagehelper.PageHelper;
import com.pre.wfj.bean.Collect;
import com.pre.wfj.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    CollectService collectService;

    //增加一个删除
    @RequestMapping("/deleteone")
    public  boolean deleteone(String hotel_id,String client_id){
        return collectService.deleteone(hotel_id,client_id);
    }

    //增加一个收藏
    @RequestMapping("/addcollect")
    public boolean addCollect(Collect collect){
        return collectService.addCollect(collect);
    }

    @RequestMapping("getAll")
    //查询一个用户的所有收藏
    public List<Collect> getCollect(String client_id,int page){
        PageHelper.startPage(page,4);
        return collectService.getCollect(client_id);
    }
    @RequestMapping("getlength")
    //查询一个用户的所有收藏
    public int getCollect(String client_id){
        return collectService.getCollect(client_id).size();
    }

    //查询一个收藏
    @RequestMapping("/getone")
    public Collect getone(String hotel_id, String client_id){
        return collectService.getone(hotel_id, client_id);
    }

}
