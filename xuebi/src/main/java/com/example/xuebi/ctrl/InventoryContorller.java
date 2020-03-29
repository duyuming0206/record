package com.example.xuebi.ctrl;

import com.example.xuebi.entity.inventory;
import com.example.xuebi.entity.record;
import com.example.xuebi.server.InventoryService;
import com.example.xuebi.server.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InventoryContorller {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    RecordService recordService;
    // 获得该仓库的所有库存,并把仓库号存入session
    @RequestMapping("getAllInventory")
    public List<inventory> getAllInventory(int wid, HttpServletRequest request){
        List<inventory> list = inventoryService.getALL(wid);
        HttpSession session = request.getSession();
        if(session.getAttribute("wid") == null){
            session.setAttribute("wid", wid);
            return list;
        }
        session.removeAttribute("wid");
        session.setAttribute("wid",wid);
        return list;
    }

    @RequestMapping("deleteInventory")
    public String deleteInventory(int iid){
        int isSuccess = inventoryService.deleteInventory(iid);
        if(isSuccess == 1){
            return "success";
        }
        return "fail";
    }

    //修改库存（出入库操作）
    @RequestMapping("updateInventory")
    public String updateInventory(inventory i){
        i.setInum(i.getInum()+i.getChangeNum());
        int isSuccess = inventoryService.updateInventory(i);
        if (isSuccess == 1){
            record r = new record();
            r.setRnum(i.getChangeNum());
            r.setMname(i.getMname());
            r.setSid(i.getSid());
            r.setWid(i.getWid());
            recordService.addRecord(r); //每次修改库存 都增加一条出入库记录
            return "success";
        }
        return "fail";
    }
}
