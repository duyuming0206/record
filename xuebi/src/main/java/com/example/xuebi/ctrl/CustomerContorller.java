package com.example.xuebi.ctrl;

import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.customer;
import com.example.xuebi.entity.warehouse;
import com.example.xuebi.server.CustomerService;
import com.example.xuebi.server.RecordService;
import com.example.xuebi.server.SortService;
import com.example.xuebi.server.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CustomerContorller {

    @Autowired
    CustomerService customerService;
    @Autowired
    SortService sortService;
    @Autowired
    WarehouseService warehouseService;

    //用户登录
    @RequestMapping("login")
    public RestResult login(customer c, HttpServletRequest request){
        customer c1 = customerService.getByName(c.getCname());
        if(c1 != null && c1.getCpassword().equals(c.getCpassword())){
            List<warehouse> list = warehouseService.getByCid(c1.getCid());
            HttpSession session = request.getSession();
            session.setAttribute("customer", c1);
            session.setAttribute("wlist", list);
            return new RestResult(null, "success");
        }
        return new RestResult(null, "fail");
    }

    @RequestMapping("updatePassword")
    public RestResult updatePassword(customer c, HttpServletRequest request){
        int isSuccess = customerService.updatePassword(c);
        if(isSuccess == 1){
            HttpSession session = request.getSession();
            session.removeAttribute("customer");
            session.setAttribute("customer", c);//更新用户信息
            return new RestResult(null, "success");
        }
        return new RestResult(null, "fail");
    }


    @RequestMapping("Regist")
    public RestResult Regist(customer c){
        customer c1 = customerService.getByName(c.getCname());
        if (c1 != null){
            return new RestResult(null, "fail");
        }
        int isSucc = customerService.addCustomer(c);
        if (isSucc == 1){
            return new RestResult(null, "success");
        }
        return new RestResult(null, "fail");
    }

    @RequestMapping("getCoustomer")
    public RestResult getCoustomer(HttpSession session){
        customer c =(customer) session.getAttribute("customer");
        System.out.println(c.getCid());
        return new RestResult(c,"");
    }

}
