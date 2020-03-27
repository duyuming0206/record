package com.example.xuebi.dao;

import com.example.xuebi.entity.sort;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


// 物料分类DAO
@Mapper
@Component
public interface SortDAO {

    @Insert("insert into sort(sname)values(#{sname})")
    public int addSort(sort s);

    @Select("select * from sort")
    public List<sort> getAll();

    @Delete("delete from sort where sid=#{sid}")
    public int deleteSort(int sid);
}
