package com.ela.myLLM.mapper;

import com.ela.myLLM.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    static final String baseSql="SELECT user_id as userId, user_nickname as nickName, user_loginname as loginName, user_loginpwd as loginPwd,user_score as score,user_img as img " +
            "FROM users ";


    @Insert("insert into myllm.users values(default,#{u.nickName},#{u.loginName},#{u.loginPwd},#{u.score},#{u.img})")
    Integer insert(@Param("u") User user);
    @Select(baseSql+"where user_loginname=#{name}")
    User selectByLoginName(@Param("name") String loginName);

    @Select(baseSql+"WHERE user_id =#{uid}")
    User selectById(@Param("uid") Integer userId);

    @Update("update users set user_nickname=#{u.nickName},user_loginPwd=#{u.loginPwd},user_score=#{u.score},user_img=#{u.img} " +
            "where user_id=#{u.userId}")
    void update(@Param("u")User user);
}
