package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from t_user where uname=#{uname}")
    public User selectOne(String uname);

    @Select("select * from t_user")
    public List<User> selectAll();

    @Insert("insert into t_user (uname,upass,truename,age,sex,phone) values(#{uname},#{upass},#{truename},#{age},#{sex},#{phone})")
    public void insert(User user);

    @Delete("delete from t_user where uno=#{uno}")
    public void delete(Integer uno);

    @Select("select * from t_user where uno=#{uno}")
    public User selectOneUser(Integer uno);

    @Update("update t_user set uname=#{uname},truename=#{truename},age=#{age},sex=#{sex},phone=#{phone} where uno=#{uno}")
    public void update(User user);

    @DeleteProvider(value = DeleteProvide.class,method = "deleteUsers")
    public void deleteUsers(Integer[] unos);
}
