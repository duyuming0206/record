package com.example.xuebi.dao;

import com.example.xuebi.entity.admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface adminDAO {

    @Select("select * from admin where aname = #{aname}")
    public admin getByName(String aname);

}
