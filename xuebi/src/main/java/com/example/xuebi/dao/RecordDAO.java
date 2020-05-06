package com.example.xuebi.dao;
// 出入库记录DAO

import com.example.xuebi.entity.record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RecordDAO {

    @Insert("insert into record(mname, rnum, sid, wid)values(#{mname}, #{rnum}, #{sid}, #{wid})")
    public int addRecord(record r); //添加出入库记录

    @Select("select * from record where (wid=#{wid}) order by rid desc")
    public List<record> getByWid(int wid); //查看某个仓库的所有物料的出入库记录

    @Select("SELECT * FROM record WHERE (DATE_FORMAT(creatdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and wid = #{wid}) and rnum < 0 and mname=#{mname}")
    public List<record> getOut(int wid, String mname); //盘点本月出库

    @Select("SELECT * FROM record WHERE (DATE_FORMAT(creatdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and wid = #{wid}) and rnum > 0 and mname=#{mname}")
    public List<record> getIn(int wid, String mname); //盘点本月入库
}
