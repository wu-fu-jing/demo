package com.pre.wfj.service;

import com.pre.wfj.bean.Hot;
import com.pre.wfj.mapper.HotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class HotService {

    @Autowired
    HotMapper hotMapper;

    //查询所有热门酒店
    public List<Hot> getAll(){
        return hotMapper.getAll();
    }
}
