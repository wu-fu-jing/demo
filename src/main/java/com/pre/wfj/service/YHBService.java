package com.pre.wfj.service;


import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.YHB;
import com.pre.wfj.mapper.YHBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class YHBService {
    @Autowired
    private YHBMapper yhbMapper;
    //查询所有用户
    public List<YHB>  getAll(String type){
        return yhbMapper.getAll(type);
    }
    //删除一个用户
    public boolean deleteone(String yhbh){
        return yhbMapper.deleteone(yhbh);
    }

    //添加用户
   public boolean addYh(YHB yhb){
        String pwd = "123456";
        String type = "酒店管理员";
        String yhbh = IdUtil.simpleUUID();
        yhb.setPwd(pwd);
        yhb.setType(type);
        yhb.setYhbh(yhbh);
        return yhbMapper.addYh(yhb);
    }

    //更新是否已经管理酒店
    public boolean updateIskong(String iskong ,String yhbh){
        return yhbMapper.updateIskong(iskong,yhbh);
    }

    //登录
    public YHB getYh(String username,String pwd){
        return yhbMapper.getYh(username,pwd);
    }
    //更新用户
    public boolean updateYh(YHB yhb){
        return yhbMapper.updateYh(yhb);
    }

    //根据用户编号查询一个用户
    public YHB seletebyid(String yhbh){
        return yhbMapper.seletebyid(yhbh);
    }

    //修改密码
    public boolean updatePwd(String pwd,String yhbh){
        return yhbMapper.updatePwd(pwd, yhbh);
    }

    //查找一个用户
    public YHB seleteone(String name){
        return yhbMapper.seleteone(name);
    }

    //通过用户名查找一个用户
    public YHB seleteousername(String username){
        return yhbMapper.seleteousername(username);
    }

    //员工管理

    //添加员工
     public boolean addyuangong(YHB yhb){
         String pwd = "123456";
         String type = "酒店员工";
         String yhbh = IdUtil.simpleUUID();
         yhb.setPwd(pwd);
         yhb.setType(type);
         yhb.setYhbh(yhbh);
         yhb.setIskong("否");
         return yhbMapper.addyuangong(yhb);
     }

    //查询所有员工
    public List<YHB>  getAllyuangong(String type,String hotel_id){
        return yhbMapper.getAllyuangong(type, hotel_id);
    }
}
