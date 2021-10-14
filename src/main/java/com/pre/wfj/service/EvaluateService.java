package com.pre.wfj.service;

import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Evaluate;
import com.pre.wfj.mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class EvaluateService {
    @Autowired
    EvaluateMapper evaluateMapper;

    //增加一条评论
    public boolean addEvaluate(Evaluate evaluate){
        String id = IdUtil.simpleUUID();
        evaluate.setId(id);
        return evaluateMapper.addEvaluate(evaluate);
    }


    //查询所有评论
    public List<Evaluate> getAll(String hotel_id){
        return evaluateMapper.getAll(hotel_id);
    }
}
