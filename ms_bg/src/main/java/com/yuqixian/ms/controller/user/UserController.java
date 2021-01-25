package com.yuqixian.ms.controller.user;

import com.yuqixian.ms.domain.user.User;
import com.yuqixian.ms.message.kafka.LoginProducer;
import com.yuqixian.ms.service.user.IUserService;
import com.yuqixian.ms.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController// @RestController = @Controller+@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    LoginProducer loginProducer;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("register")
    public Map<String, Object> test(String username, String password, String email, String telephone) {
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 1;// 注册成功
        if(userService.getUserByUsername(username) != null) {// 用户名已存在
            flag = 0;// 用户名已存在，注册失败
        } else {
            User user = new User(username,password, email, telephone, 0);// 默认注册的用户为普通用户
            userService.saveUser(user);

            // 注册成功之后，发送邮件
            // 1. 直接发送，并发量高的时候会出现问题
            // MailUtils.sendMail(email, username);
            // 2.使用kafka消息队列发送
            loginProducer.produceMessage(email, username);

        }
        map.put("flag", flag);
        return map;
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping("login")
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        int flag = 1;// 登录成功
        User user = userService.getUserByUsername(username);// 用户名唯一，可以根据用户名获取用户
        if(user == null) {// 判断用户名是否存在
            flag = 0;
        } else {// 判断密码是否正确
            // 先加密再判断，因为数据库中存储的是加密后的密码
            // 合理的办法是从数据库读取出来解密，再进行判断
            String pwd = MD5Utils.code(password);
            if(!pwd.equals(user.getPassword())) {
                flag = 0;
            }
        }
        map.put("flag", flag);
        return map;
    }

    /**
     * 查询用户
     * @return
     */
    @RequestMapping("queryUsers")
    public Map<String, Object> queryUsers(String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> list = null;
        if(username == null || username.equals("")) {// 判断用户名是否存在
            list = userService.getAllUsers();
        } else {
            list = userService.getUserListByUsername(username);
        }
        map.put("list", list);
        return map;
    }

}
