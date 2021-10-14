package com.pre.wfj.controller;

import com.pre.wfj.bean.Evaluate;
import com.pre.wfj.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    EvaluateService evaluateService;

    //增加一条评论
    @RequestMapping("/addEvaluate")
    public boolean addEvaluate(Evaluate evaluate){
        return evaluateService.addEvaluate(evaluate);
    }

    //查询所有评论
    @RequestMapping("getAll")
    public List<Evaluate> getAll(String hotel_id){
        return evaluateService.getAll(hotel_id);
    }
}
