package com.example.xuebi.dao;

import com.example.xuebi.entity.customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface customerDAO {

    //注册
    @Insert("insert into customer(cname, cpassword)VALUES(#{cname}, #{cpassword})")
    public void addCustomer(customer c);


    //根据用户名查询 用于登录
    @Select("select * from customer where cname = #{cname}")
    public customer getByName(String cname);

    //修改密码
    @Update("update costomer set cpassword = #{cpassword} where cid = #{cid}")
    public int updatePassword(customer c);
}
