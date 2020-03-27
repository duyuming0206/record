package com.example.xuebi.server;

import com.example.xuebi.entity.customer;

public interface CustomerService {

    public void addCustomer(customer c);  //注册

    public customer getByName(String cname);  //根据用户名查询 用于登录

    public int updatePassword(customer c);  //修改密码


}
