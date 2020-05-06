package com.example.xuebi.server.impl;

import com.example.xuebi.dao.RecordDAO;
import com.example.xuebi.entity.record;
import com.example.xuebi.server.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {


    @Autowired
    RecordDAO recordDAO;


    @Override
    public int addRecord(record r) {
        return recordDAO.addRecord(r);
    }

    @Override
    public List<record> getByWid(int wid) {
        return recordDAO.getByWid(wid);
    }

    @Override
    public List<record> getOut(int wid, String mname) {
        return recordDAO.getOut(wid,mname);
    }

    @Override
    public List<record> getIn(int wid,String mname) {
        return recordDAO.getIn(wid,mname);
    }
}
