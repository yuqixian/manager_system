package com.yuqixian.ms.service.user;

import com.yuqixian.ms.domain.user.User;

import java.util.List;

public interface IUserService {

    void saveUser(User user);// 注册

    User getUserByUsername(String username);// 根据用户名获取用户

    List<User> getUserListByUsername(String username);// 根据用户名查询用户

    List<User> getAllUsers();// 查询所有用户
}
