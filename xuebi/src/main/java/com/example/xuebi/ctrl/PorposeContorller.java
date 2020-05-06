package com.example.xuebi.ctrl;

import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.porpose;
import com.example.xuebi.server.PorposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PorposeContorller {

    @Autowired
    PorposeService porposeService;

    @RequestMapping("addPorpose")
    public RestResult addPorpose(porpose p){
        int isSuccess = porposeService.addPorpose(p);
        if (isSuccess == 1){
            return new RestResult(null, "success");
        }
        return new RestResult(null, "fail");
    }

    //获取所有建议
    @RequestMapping("getAllPorpose")
    public List<porpose> getAllPorpose(){
        List<porpose> list = porposeService.getALL();
        return list;
    }
}
