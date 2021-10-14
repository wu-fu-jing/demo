package com.pre.wfj.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.pre.wfj.bean.Client;
import com.pre.wfj.bean.Riqi;
import com.pre.wfj.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class) //有事务提交的
public class ClientService {
    @Autowired
    ClientMapper clientMapper;

    //删除一个用户
    public boolean deleteone(String id){
        return clientMapper.deleteone(id);
    }

    //得到所有客户
    public List<Client> getAll(){
        return clientMapper.getAll();
    }

    //注册
    public boolean addClient(Client client){
        String simpleUUID = IdUtil.simpleUUID();
        String today= DateUtil.today();
        String tx = "http://localhost:7777/files/ef9a66ee888f4aa8899dd1bfc2b0af3b";
        client.setTx(tx);
        client.setData(today);
        client.setId(simpleUUID);
        return clientMapper.addClient(client);
    }
//    判断是否已经被注册
    public Client register(String phone){
        return clientMapper.register(phone);
    }

    //登录
    public Client login(String phone,String pwd){
        return clientMapper.login(phone,pwd);
    }

    //注册人数趋势
    public List<Riqi>  getqushi(){
        return clientMapper.getqushi();
    }

    //改密码
     public boolean updatePwd(String pwd,String id){
        return clientMapper.updatePwd(pwd,id);
    }
}
