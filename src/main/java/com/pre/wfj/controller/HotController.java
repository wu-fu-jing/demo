package com.pre.wfj.controller;

import com.pre.wfj.bean.Hot;
import com.pre.wfj.service.HotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hot")
public class HotController {
    @Autowired
    HotService hotService;

    //查询所有热门酒店
    @RequestMapping("/getAll")
    public List<Hot> getAll(){
        return hotService.getAll();
    }
}
