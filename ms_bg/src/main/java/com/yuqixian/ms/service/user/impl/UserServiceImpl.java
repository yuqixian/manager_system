package com.yuqixian.ms.service.user.impl;

import com.yuqixian.ms.domain.user.User;
import com.yuqixian.ms.mapper.user.UserMapper;
import com.yuqixian.ms.service.user.IUserService;
import com.yuqixian.ms.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired// DI注解
    UserMapper userMapper;

    // 用户注册
    @Override
    public void saveUser(User user) {
        // 对密码进行MD5加密
        String password = user.getPassword();
        String pwd = MD5Utils.code(password);
        user.setPassword(pwd);// 重新设置密码
        userMapper.saveUser(user);
    }

    // 根据用户名获取用户
    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    // 根据用户名搜索
    @Override
    public List<User> getUserListByUsername(String username) {
        return userMapper.getUserListByUsername(username);
    }

    // 查询所有用户
    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
