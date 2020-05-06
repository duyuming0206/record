package com.example.xuebi.ctrl;

import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.customer;
import com.example.xuebi.entity.warehouse;
import com.example.xuebi.server.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class WarehouseContorller {

    @Autowired
    WarehouseService warehouseService;
    //新建仓库
    @RequestMapping("addWarehouse")
    public RestResult addWarehouse(warehouse w, HttpServletRequest request){
        int isSuccess = warehouseService.addWarehouse(w);
        if(isSuccess == 1){
            List<warehouse> list = warehouseService.getByCid(w.getCid());
            HttpSession session = request.getSession();
            session.removeAttribute("wlist");
            session.setAttribute("wlist", list);//刷新仓库
            return new RestResult(null,"success");
        }
        return new RestResult(null,"fail");
    }

    // 修改仓库名称
    @RequestMapping("updateWarehouseName")
    public RestResult updateWarehouseName(warehouse w, HttpServletRequest request){
        int isSuccess = warehouseService.updateWname(w.getWname(),w.getWid());
        if(isSuccess == 1){
            List<warehouse> list = warehouseService.getByCid(w.getCid());
            HttpSession session = request.getSession();
            session.removeAttribute("wlist");
            session.setAttribute("wlist", list);//刷新仓库
            return new RestResult(null,"success");
        }
        return new RestResult(null,"fail");
    }

    @RequestMapping("getAllWarehouse")
    public List<warehouse> getAllWarehouse(HttpSession session){
        customer c = (customer)session.getAttribute("customer");
        List<warehouse> list = warehouseService.getByCid(c.getCid());
        return list;
    }
    @RequestMapping("setWid")
    public void setWid(warehouse w, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("wid", w.getWid());
    }

}
