package com.example.xuebi.dao;

import com.example.xuebi.entity.material;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
// 物料DAO

@Mapper
@Component
public interface materialDAO {

    @Insert("insert into material(mname, sid, cid)values(#{mname}, #{sid}, #{cid})")
    public int addMaterial(material m);  //添加物料

    @Select("select * from material")
    public List<material> getAll(); //获得所有物料

    @Delete("delete from material where mid=#{mid}")
    public int deleteMaterial(int mid); //删除物料
}
