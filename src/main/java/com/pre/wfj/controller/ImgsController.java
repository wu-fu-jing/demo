package com.pre.wfj.controller;

import com.pre.wfj.bean.Imgs;
import com.pre.wfj.service.ImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/imgs")
public class ImgsController {
    @Autowired
    ImgsService imgsService;

    //添加一个图片
    @RequestMapping("/addimgs")
    public boolean addImgs(Imgs imgs){
        return imgsService.addImgs(imgs);
    }

    //删除一个图片
    @RequestMapping("/deleteone")
    public boolean deleteone(String path){
        return imgsService.deleteone(path);
    }
}
