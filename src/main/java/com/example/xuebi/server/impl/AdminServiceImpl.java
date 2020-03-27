package com.example.xuebi.server.impl;

import com.example.xuebi.dao.AdminDAO;
import com.example.xuebi.entity.admin;
import com.example.xuebi.server.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;


    @Override
    public admin getByName(String aname) {
        return adminDAO.getByName(aname);
    }
}
