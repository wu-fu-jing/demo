package com.pre.wfj.controller;


import com.pre.wfj.bean.Client;
import com.pre.wfj.bean.Riqi;
import com.pre.wfj.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;


    @RequestMapping("/deleteone")
    //删除一个用户
    public boolean deleteone(String id){
        return clientService.deleteone(id);
    }

    @RequestMapping("/getAll")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @RequestMapping("/register")
    public Client register(String phone){
        return clientService.register(phone);
    }

    @RequestMapping("/login")
    public Client login(String phone,String pwd){
        return clientService.login(phone,pwd);
    }

    @RequestMapping("/addClient")
    public boolean addClient(Client client){
        System.out.println(client);
        return clientService.addClient(client);
    }

    //注册人数趋势
    @RequestMapping("getqushi")
    public List<Riqi>  getqushi(){
        return clientService.getqushi();
    }

    //改密码
    @RequestMapping("/updatePwd")
    public boolean updatePwd(String pwd,String id){
        return clientService.updatePwd(pwd,id);
    }
}
