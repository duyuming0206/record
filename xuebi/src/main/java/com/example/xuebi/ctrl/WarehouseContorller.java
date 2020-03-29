package com.example.xuebi.ctrl;

import com.example.xuebi.entity.warehouse;
import com.example.xuebi.server.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WarehouseContorller {

    @Autowired
    WarehouseService warehouseService;
    //新建仓库
    @RequestMapping("addWarehouse")
    public String addWarehouse(warehouse w, HttpServletRequest request){
        int isSuccess = warehouseService.addWarehouse(w);
        if(isSuccess == 1){
            List<warehouse> list = warehouseService.getByCid(w.getCid());
            HttpSession session = request.getSession();
            session.removeAttribute("wlist");
            session.setAttribute("wlist", list);//刷新仓库
            return "success";
        }
        return "fail";
    }

    // 修改仓库名称
    @RequestMapping("updateWarehouseName")
    public String updateWarehouseName(warehouse w, HttpServletRequest request){
        int isSuccess = warehouseService.updateWname(w.getWname(),w.getWid());
        if(isSuccess == 1){
            List<warehouse> list = warehouseService.getByCid(w.getCid());
            HttpSession session = request.getSession();
            session.removeAttribute("wlist");
            session.setAttribute("wlist", list);//刷新仓库
            return "success";
        }
        return "fail";
    }
}
