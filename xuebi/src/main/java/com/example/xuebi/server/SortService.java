package com.example.xuebi.server;

import com.example.xuebi.entity.sort;

import java.util.List;

public interface SortService {

    public int addSort(sort s);  //添加分类

    public List<sort> getAll();  //获得所有分类

    public int deleteSort(int sid);  //删除分类
}
