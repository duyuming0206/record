package com.example.xuebi.ctrl;

import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.inventory;
import com.example.xuebi.entity.material;
import com.example.xuebi.server.InventoryService;
import com.example.xuebi.server.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MaterialContorller {

    @Autowired
    MaterialService materialService;
    @Autowired
    InventoryService inventoryService;



    @RequestMapping("getMaterialAll")
    public List<material> getMaterialAll(int cid){
        List<material> list = materialService.getAll(cid);
        return list;
    }

    @RequestMapping("addMaterial")
    public RestResult addMaterial(material m, HttpSession session){
        int wid = (int)session.getAttribute("wid");
        int isSuccess = materialService.addMaterial(m);
        if(isSuccess == 1){
            inventory i = new inventory();
            i.setInum(0);
            i.setMname(m.getMname());
            i.setSid(m.getSid());
            i.setWid(wid);
            inventoryService.addInventroy(i);//添加物料后，设置初始库存为0
            return new RestResult(null, "success");
        }
        return new RestResult(null, "fail");
    }

    @RequestMapping("deleteMaterial")
    public RestResult deleteMaterial(int mid){

        int isSuccess = materialService.deleteMaterial(mid);
        if(isSuccess == 1){
            return new RestResult(null, "success");
        }
        return new RestResult(null, "fail");
    }


}
