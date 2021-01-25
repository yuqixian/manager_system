package com.yuqixian.ms.mapper.user;

import com.yuqixian.ms.domain.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 用户注册
     */
    @Insert("INSERT INTO user(username,password,email,telephone,level) "
            + "VALUES(#{username},#{password},#{email},#{telephone},#{level})")
    void saveUser(User user);

    /**
     * 根据用户名查询用户
     */
    @Select("select username,password,email,telephone,level from user where username=#{username}")
    User getUserByUsername(String username);

    /**
     * 根据用户名搜索用户
     * @param username
     * @return
     */
    @Select("select username,password,email,telephone,level from user where username like '${username}%'")
    List<User> getUserListByUsername(@Param("username") String username);

    @Select("select username,password,email,telephone,level from user")
    List<User> getAllUsers();

}