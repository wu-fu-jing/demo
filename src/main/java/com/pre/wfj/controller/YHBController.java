package com.pre.wfj.controller;



import com.pre.wfj.bean.YHB;
import com.pre.wfj.service.YHBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/yh")
public class YHBController {
    @Autowired
    private YHBService yhbService;
    //查询所有用户
    @RequestMapping("/getAll")
    public List<YHB> getAll(String type){
        return yhbService.getAll(type);
    }
    @RequestMapping("/deleteone")
    //删除一个用户
    public boolean deleteone(String yhbh){
        return yhbService.deleteone(yhbh);
    }

    //    添加用户
    @RequestMapping("/addYh")
    public boolean addYh(YHB yhb){
        return yhbService.addYh(yhb);
    }

    //更新用户
    @RequestMapping("/updateYh")
    public boolean updateYh(YHB yhb){
        return yhbService.updateYh(yhb);
    }

    //登录
    @RequestMapping("/getYh")
    public YHB getYh(String username,String pwd){

        return yhbService.getYh(username,pwd);
    }

    //根据用户编号查询一个用户
    @RequestMapping("/getbyid")
    public YHB seletebyid(String yhbh){
        return yhbService.seletebyid(yhbh);
    }

    //修改密码
    @RequestMapping("/updatePwd")
    public boolean updatePwd(String pwd,String yhbh){
        return yhbService.updatePwd(pwd, yhbh);
    }

    //查找一个用户
    @RequestMapping("/getUsername")
    public YHB seleteousername(String username){
        return yhbService.seleteousername(username);
    }

    //查找一个用户
    @RequestMapping("/getName")
    public YHB seleteone(String name){
        return yhbService.seleteone(name);
    }

    //更新是否已经管理酒店
    @RequestMapping("/updateIskong")
    public boolean updateIskong(String iskong ,String yhbh){
        return yhbService.updateIskong(iskong,yhbh);
    }




    //员工管理

    //添加员工
    @RequestMapping("/addyuangong")
    public boolean addyuangong(YHB yhb){
        return yhbService.addyuangong(yhb);
    }

    //查询所有员工
    @RequestMapping("/getAllyuangong")
    public List<YHB>  getAllyuangong(String type,String hotel_id){
        return yhbService.getAllyuangong(type, hotel_id);
    }
}
