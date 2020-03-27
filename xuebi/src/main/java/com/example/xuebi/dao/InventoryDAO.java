package com.example.xuebi.dao;

//库存DAO

import com.example.xuebi.entity.inventory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface InventoryDAO {

    @Select("select * from inventory where wid=#{wid}")
    public List<inventory> getALL(int wid);  //查询仓库内所有库存

    @Select("select * from inventory where sid=#{sid} and wid=#{wid}")
    public List<inventory> getBySort(@Param("sid")int sid, @Param("wid")int wid);  //按分类查询库存

    @Update("update inventory set inum=#{inum} where iid=#{iid}")
    public int updateInventory(inventory i); //修改库存

    @Delete("delete from inventory where iid=#{iid}")
    public int deleteInventory(int iid); //删除库存

    @Insert("insert into inventory(mname, inum, wid, sid)values(#{mname}, #{inum}, #{wid}, #{sid})")
    public void addInventroy(inventory i); //添加库存
}
