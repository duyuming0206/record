package com.example.xuebi.dao;

// 评论DAO

import com.example.xuebi.entity.porpose;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface porposeDAO {

    @Insert("insert into porpose(pcontent, cid)values(#{pcontent}, #{cid})")
    public int addPorpose(porpose p); //发表评论

    @Select("select * from porpose order by pid desc")
    public List<porpose> getALL(); //查看评论

    @Delete("delete from porpose where pid=#{pid}")
    public int deletePoppose(int pid); //删除评论
}
