package com.example.xuebi.server.impl;


import com.example.xuebi.dao.MaterialDAO;
import com.example.xuebi.entity.material;
import com.example.xuebi.server.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialDAO materialDAO;

    @Override
    public int addMaterial(material m) {
        return materialDAO.addMaterial(m);
    }

    @Override
    public List<material> getAll() {
        return materialDAO.getAll();
    }

    @Override
    public int deleteMaterial(int mid) {
        return materialDAO.deleteMaterial(mid);
    }
}
