package com.example.xuebi.ctrl;


import com.example.xuebi.entity.Count;
import com.example.xuebi.entity.RestResult;
import com.example.xuebi.entity.record;
import com.example.xuebi.server.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class RecordContorller {

    @Autowired
    RecordService recordService;

    //获取某个仓库所有的出入库操作
    @RequestMapping("getAllRecord")
    public List<record> getAllRecord(HttpSession session){
        int wid = (int)session.getAttribute("wid");
        List<record> list = recordService.getByWid(wid);
        return list;
    }

    //出库盘点
    @RequestMapping("getOut")
    public RestResult getOut(HttpSession session){
        int wid = (int)session.getAttribute("wid");
        String mname = (String)session.getAttribute("mname");
        List<record> list = recordService.getOut(wid,mname); //获得本月某件物料所有的出库
        Count count = new Count();
        count.setNum(0); //初始化
        for (record c1 : list) {
            count.setNum(count.getNum() + c1.getRnum());
        } // 遍历list 把所有出库数据都加起来
        count.setName(list.get(1).getMname());
        return new RestResult(count, "success");
    }

    //入库盘点
    @RequestMapping("getIn")
    public RestResult getIn(HttpSession session) {
        int wid = (int) session.getAttribute("wid");
        String mname = (String) session.getAttribute("mname");
        List<record> list = recordService.getIn(wid, mname); //获得本月某件物料所有的入库
        Count count = new Count();
        count.setNum(0); //初始化
        for (record c1 : list) {
            count.setNum(count.getNum() + c1.getRnum());
        } // 遍历list 把所有出库数据都加起来
        count.setName(list.get(1).getMname());
        return new RestResult(count, "success");
    }
}
