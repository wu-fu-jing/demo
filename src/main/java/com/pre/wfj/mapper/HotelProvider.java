package com.pre.wfj.mapper;

import com.pre.wfj.bean.Hotel;

public class HotelProvider {
   public String getListSql(Hotel hotel){
       StringBuffer sql = new StringBuffer("SELECT  phone,leaves,id,address,picture,name,kind,star,price,synopsis,yhbh,data FROM hotel where 1=1");
       if(null!=hotel){
        if(hotel.getAddress()!=null&&hotel.getAddress()!=""){
            sql.append("and address like concat('%',#{address},'%')");
        }
           if(hotel.getName()!=null&&hotel.getName()!=""){
               sql.append("and address like concat('%',#{address},'%')");
           }
       }

       return sql.toString();
   }
}
