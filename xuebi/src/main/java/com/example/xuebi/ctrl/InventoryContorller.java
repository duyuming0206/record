package com.example.xuebi.ctrl;

import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.inventory;
import com.example.xuebi.entity.record;
import com.example.xuebi.server.InventoryService;
import com.example.xuebi.server.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class InventoryContorller {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    RecordService recordService;
    // 把仓库号存入session
    @RequestMapping("getAllInventory")
    public void getAllInventory(int wid, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("wid") == null){
            session.setAttribute("wid", wid);
        }
        session.removeAttribute("wid");
        session.setAttribute("wid",wid);
    }

    @RequestMapping("deleteInventory")
    public RestResult deleteInventory(int iid){
        int isSuccess = inventoryService.deleteInventory(iid);
        if(isSuccess == 1){
            return new RestResult(null,"success");
        }
        return new RestResult(null,"success");
    }

    //修改库存（出入库操作）
    @RequestMapping("updateInventory")
    public RestResult updateInventory(inventory i){
        inventory i1 = inventoryService.getOneById(i.getIid());
        i.setInum(i1.getInum()+i.getChangeNum());
        int isSuccess = inventoryService.updateInventory(i);
        if (isSuccess == 1){
            record r = new record();
            r.setMname(i1.getMname());
            r.setRnum(i.getChangeNum());
            r.setSid(i1.getSid());
            r.setWid(i1.getWid());
            recordService.addRecord(r); //每次修改库存 都增加一条出入库记录
            return new RestResult(null,"success");
        }
        return new RestResult(null,"fail");
    }

    @RequestMapping("getInventorys")
    public List<inventory> getInventorys(HttpSession session){
        int wid = (int)session.getAttribute("wid");
        System.out.println(wid);
        List<inventory> list = inventoryService.getALL(wid);
        return list;
    }

    public void setMname(inventory i, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("mname", i.getMname());
    }
}
