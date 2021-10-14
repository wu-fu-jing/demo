package com.pre.wfj.service;


import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Imgs;
import com.pre.wfj.mapper.ImgsMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class ImgsService {
    @Autowired
    ImgsMapper imgsMapper;

    //添加一个图片
    public boolean addImgs(Imgs imgs){
        String id = IdUtil.simpleUUID();
        imgs.setId(id);
        return imgsMapper.addImgs(imgs);
    }

    //删除一个图片
    public boolean deleteone(String path){
        return imgsMapper.deleteone(path);
    }
}
