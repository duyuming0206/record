package com.example.xuebi.server;

import com.example.xuebi.entity.inventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InventoryService {

    public List<inventory> getALL(int wid);  //查询仓库内所有库存

    public List<inventory> getBySort(@Param("sid")int sid, @Param("wid")int wid);  //按分类查询库存

    public int updateInventory(inventory i); //修改库存

    public int deleteInventory(int iid); //删除库存

    public void addInventroy(inventory i); //添加库存
}
