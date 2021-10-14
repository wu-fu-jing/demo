package com.pre.wfj.mapper;

import com.pre.wfj.bean.Hotel;
import com.pre.wfj.bean.Imgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImgsMapper {

    //添加一个图片
    @Insert("INSERT INTO imgs(id,path,ids) VALUES(#{id},#{path},#{ids})")
    boolean addImgs(Imgs imgs);

    //删除一个图片
    @Delete("DELETE FROM imgs WHERE path=#{path}")
    boolean deleteone(String path);
}
