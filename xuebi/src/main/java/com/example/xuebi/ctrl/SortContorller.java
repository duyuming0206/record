package com.example.xuebi.ctrl;


import com.example.xuebi.entity.sort;
import com.example.xuebi.server.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SortContorller {

    @Autowired
    SortService sortService;

    //添加分类
    @RequestMapping("addSort")
    public String addSort(sort s){
       int isSuccess = sortService.addSort(s);
        if(isSuccess > 0){
            return "success";
        }
        return "fail";
    }

    //删除分类
    @RequestMapping("deleteSort")
    public String deleteSort(int sid){
        int isSuccess = sortService.deleteSort(sid);
        if(isSuccess > 0){
            return "success";
        }
        return "fail";
    }
}
