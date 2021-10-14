package com.pre.wfj.service;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Occupancy_record;
import com.pre.wfj.mapper.Occupancy_recordMapper;
import com.pre.wfj.util.DataUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class Occupancy_recordService {

    @Autowired
    Occupancy_recordMapper occupancy_recordMapper;

    //退房更新
    public boolean updateOccupancy(Occupancy_record occupancy_record){
        Date date = new Date();
        DateTime time = new DateTime(date);
        occupancy_record.setDeparture(time+"");
        occupancy_record.setType("已完成");
        return occupancy_recordMapper.updateOccupancy(occupancy_record);
    }
    //续住更新
    public boolean updateXuOccupancy(Occupancy_record occupancy_record){
        Date date = DateUtil.parse(occupancy_record.getCheckin());
        int day = Integer.valueOf(occupancy_record.getDay());
        String format = DateUtil.format(date,"yyyy-MM-dd")+" "+occupancy_record.getDeparture();
        Date date2 = DateUtil.parse(format);
        DateTime newDate = DateUtil.offsetDay(date2,day);
        occupancy_record.setDeparture(newDate+"");
        return occupancy_recordMapper.updateXuOccupancy(occupancy_record);
    }

    //增加一个开房记录
    public boolean AddOccupancy(Occupancy_record occupancy_record){
        String id = IdUtil.simpleUUID();
        Date date = new Date();
        DateTime time = new DateTime(date);
        occupancy_record.setId(id);
        occupancy_record.setCheckin(time+"");
        occupancy_record.setFine("0");
        occupancy_record.setType("正在入住");
            String today= DateUtil.today();
            date = DateUtil.parse(today +" " + occupancy_record.getDeparture());
            int day = Integer.valueOf(occupancy_record.getDay());
            DateTime newDate = DateUtil.offsetDay(date,day);
            occupancy_record.setDeparture(newDate+"");
        return occupancy_recordMapper.AddOccupancy(occupancy_record);
    }

    //查询开房记录
    public List<Occupancy_record> getAll(String type,String hotel_id){
        return occupancy_recordMapper.getAll(type,hotel_id);
    }
    //删除一个开房记录
    public boolean deleteone(String id){
        return occupancy_recordMapper.deleteone(id);
    }

}
