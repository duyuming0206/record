package com.example.xuebi.server.impl;

import com.example.xuebi.dao.CustomerDAO;
import com.example.xuebi.entity.customer;
import com.example.xuebi.server.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void addCustomer(customer c) {
        customerDAO.addCustomer(c);
    }

    @Override
    public customer getByName(String cname) {
        return customerDAO.getByName(cname);
    }

    @Override
    public int updatePassword(customer c) {
        return customerDAO.updatePassword(c);
    }
}
