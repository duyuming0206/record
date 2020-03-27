package com.example.xuebi.server.impl;

import com.example.xuebi.dao.InventoryDAO;
import com.example.xuebi.entity.inventory;
import com.example.xuebi.server.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {


    @Autowired
    InventoryDAO inventoryDAO;

    @Override
    public List<inventory> getALL(int wid) {
        return inventoryDAO.getALL(wid);
    }

    @Override
    public List<inventory> getBySort(int sid, int wid) {
        return inventoryDAO.getBySort(sid, wid);
    }

    @Override
    public int updateInventory(inventory i) {
        return inventoryDAO.updateInventory(i);
    }

    @Override
    public int deleteInventory(int iid) {
        return inventoryDAO.deleteInventory(iid);
    }

    @Override
    public void addInventroy(inventory i) {
        inventoryDAO.addInventroy(i);
    }
}
