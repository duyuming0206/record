package com.example.xuebi.ctrl;

import com.example.xuebi.entity.inventory;
import com.example.xuebi.entity.material;
import com.example.xuebi.server.InventoryService;
import com.example.xuebi.server.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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
    public String addMaterial(material m, int wid){

        int isSuccess = materialService.addMaterial(m);
        if(isSuccess == 1){
            inventory i = new inventory();
            i.setInum(0);
            i.setMname(m.getMname());
            i.setSid(m.getSid());
            i.setWid(wid);
            inventoryService.addInventroy(i);//添加物料后，设置初始库存为0
            return "success";
        }
        return "fail";
    }

    @RequestMapping("deleteMaterial")
    public String deleteMaterial(int mid){

        int isSuccess = materialService.deleteMaterial(mid);
        if(isSuccess == 1){
            return "success";
        }
        return "fail";
    }


}
