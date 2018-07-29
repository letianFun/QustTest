package com.qfedu.dao;

import com.qfedu.domain.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {


    //登录
    @Select("select * from t_user where username=#{username} and flag=1 and role = #{role}")
    @ResultType(User.class)
    User queryByName(@Param("username") String username,@Param("role") int role);
    //注册
    @Insert("insert into t_user(username,password,sex,role,flag) values(#{username},#{password},#{sex},1,1)")
    int insert(User user);
    //登录成功之前修改时间,
    @Update("update t_user set befortime = logintime,logintime = now() where username = username")
    int updateLoginTime(String username);

    //查询有用户的数量
    @Select("select count(1) from t_user where flag = 1 AND role = 1")
    @ResultType(Long.class)
    Long queryUserCount();

}
