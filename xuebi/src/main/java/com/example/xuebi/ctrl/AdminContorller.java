package com.example.xuebi.ctrl;

import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.admin;
import com.example.xuebi.server.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class AdminContorller {

    @Autowired
    AdminService adminService;

    //登录
    @RequestMapping("aLogin")
    public RestResult aLogin(admin a, HttpServletRequest request){
        admin a1 = adminService.getByName(a.getAname());
       if(a1 != null && a1.getApassword().equals(a.getApassword())){
           HttpSession session = request.getSession();
           session.setAttribute("admin", a);
           return new RestResult(null,"success");
       }
        return new RestResult(null,"fail");
    }



}
