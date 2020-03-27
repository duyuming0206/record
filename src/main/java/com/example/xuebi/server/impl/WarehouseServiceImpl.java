package com.example.xuebi.server.impl;

import com.example.xuebi.dao.WarehouseDAO;
import com.example.xuebi.entity.warehouse;
import com.example.xuebi.server.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    WarehouseDAO warehouseDAO;

    @Override
    public int addWarehouse(warehouse w) {
        return warehouseDAO.addWarehouse(w);
    }

    @Override
    public int updateWname(String wname, int wid) {
        return warehouseDAO.updateWname(wname, wid);
    }

    @Override
    public List<warehouse> getByCid(int cid) {
        return warehouseDAO.getByCid(cid);
    }
}
