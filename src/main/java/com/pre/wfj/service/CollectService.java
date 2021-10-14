package com.pre.wfj.service;

import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Collect;
import com.pre.wfj.bean.Hotel;
import com.pre.wfj.mapper.CollectMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class CollectService {
    @Autowired
    CollectMapper collectMapper;

    //增加一个删除
    public  boolean deleteone(String hotel_id,String client_id){
        return collectMapper.deleteone(hotel_id,client_id);
    }

    //增加一个收藏
    public boolean addCollect(Collect collect){
        String simpleUUID = IdUtil.simpleUUID();
        collect.setId(simpleUUID);
        return collectMapper.addCollect(collect);
    }
    //查询一个用户的所有收藏
    public List<Collect> getCollect(String client_id){
        return collectMapper.getCollect(client_id);
    }

    //查询一个收藏
    public Collect getone(String hotel_id, String client_id){
        return collectMapper.getone(hotel_id, client_id);
    }

}
