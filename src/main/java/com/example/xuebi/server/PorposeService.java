package com.example.xuebi.server;

import com.example.xuebi.entity.porpose;

import java.util.List;

public interface PorposeService {

    public int addPorpose(porpose p); //发表评论

    public List<porpose> getALL(); //查看评论

    public int deletePoppose(int pid); //删除评论
}
