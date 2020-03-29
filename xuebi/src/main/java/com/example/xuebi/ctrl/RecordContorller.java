package com.example.xuebi.ctrl;


import com.example.xuebi.entity.record;
import com.example.xuebi.server.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RecordContorller {

    @Autowired
    RecordService recordService;

    //获取某个仓库所有的出入库操作
    @RequestMapping("getAllRecord")
    public List<record> getAllRecord(int wid){
        List<record> list = recordService.getByWid(wid);
        return list;
    }
}
