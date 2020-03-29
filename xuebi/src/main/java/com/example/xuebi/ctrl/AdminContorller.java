package com.example.xuebi.ctrl;

import com.example.xuebi.entity.admin;
import com.example.xuebi.server.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class AdminContorller {

    @Autowired
    AdminService adminService;

    //登录
    @RequestMapping("aLogin")
    public String aLogin(admin a, HttpServletRequest request){
       if(a.getApassword().equals(adminService.getByName(a.getAname()).getApassword())){
           HttpSession session = request.getSession();
           session.setAttribute("admin", a);
           return "success";

       }
        return "fail";
    }



}
