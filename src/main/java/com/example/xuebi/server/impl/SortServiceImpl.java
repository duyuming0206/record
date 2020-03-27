package com.example.xuebi.server.impl;

import com.example.xuebi.dao.SortDAO;
import com.example.xuebi.entity.sort;
import com.example.xuebi.server.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    @Autowired
    SortDAO sortDAO;

    @Override
    public int addSort(sort s) {
        return sortDAO.addSort(s);
    }

    @Override
    public List<sort> getAll() {
        return sortDAO.getAll();
    }

    @Override
    public int deleteSort(int sid) {
        return sortDAO.deleteSort(sid);
    }
}
