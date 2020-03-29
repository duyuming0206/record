package com.example.xuebi.server;

import com.example.xuebi.entity.material;

import java.util.List;

public interface MaterialService {

    public int addMaterial(material m);  //添加物料

    public List<material> getAll(int cid); //获得所有物料

    public int deleteMaterial(int mid); //删除物料
}
