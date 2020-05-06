package com.example.xuebi.ctrl;


import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.customer;
import com.example.xuebi.entity.sort;
import com.example.xuebi.server.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class SortContorller {

    @Autowired
    SortService sortService;

    //添加分类
    @RequestMapping("addSort")
    public RestResult addSort(sort s){
       int isSuccess = sortService.addSort(s);
        if(isSuccess == 1){
            return new RestResult(null,"success");
        }
        return new RestResult(null,"fail");
    }

    //删除分类
    @RequestMapping("deleteSort")
    public RestResult deleteSort(int sid){
        int isSuccess = sortService.deleteSort(sid);
        if(isSuccess == 1){
            return new RestResult(null,"success");
        }
        return new RestResult(null,"fail");
    }

    @RequestMapping("getSort")
    public List<sort> getSort(){
        List<sort> list = sortService.getAll();
        return list;
    }
}
