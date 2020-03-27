package com.example.xuebi.dao;
//仓库DAO

import com.example.xuebi.entity.warehouse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface warehouseDAO {

    @Insert("insert into warehouse(wname, cid)values(#{wname}, #{cid})")
    public int addWarehouse(warehouse w);  //添加仓库

    @Update("update warehouse set wname=#{wname} where wid=#{wid}")
    public int updateWname(@Param("wname")String wname, @Param("wid")int wid);

    @Select("select * from warehouse where cid=#{cid}")
    public List<warehouse> getByCid(@Param("cid")int cid);
}
