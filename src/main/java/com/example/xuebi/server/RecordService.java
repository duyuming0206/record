package com.example.xuebi.server;

import com.example.xuebi.entity.record;

import java.util.List;

public interface RecordService {

    public int addRecord(record r); //添加出入库记录

    public List<record> getByWid(int wid); //查看某个仓库的所有物料的出入库记录
}
