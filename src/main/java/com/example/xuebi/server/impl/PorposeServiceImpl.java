package com.example.xuebi.server.impl;

import com.example.xuebi.dao.PorposeDAO;
import com.example.xuebi.entity.porpose;
import com.example.xuebi.server.PorposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorposeServiceImpl implements PorposeService {

    @Autowired
    PorposeDAO porposeDAO;

    @Override
    public int addPorpose(porpose p) {
        return porposeDAO.addPorpose(p);
    }

    @Override
    public List<porpose> getALL() {
        return porposeDAO.getALL();
    }

    @Override
    public int deletePoppose(int pid) {
        return porposeDAO.deletePoppose(pid);
    }
}
