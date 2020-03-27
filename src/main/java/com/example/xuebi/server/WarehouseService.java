package com.example.xuebi.server;

import com.example.xuebi.entity.warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseService {

    public int addWarehouse(warehouse w);  //添加仓库

    public int updateWname(@Param("wname")String wname, @Param("wid")int wid);

    public List<warehouse> getByCid(@Param("cid")int cid);
}
