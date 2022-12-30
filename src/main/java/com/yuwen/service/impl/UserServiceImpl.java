package com.yuwen.service.impl;

import com.yuwen.mapper.UserMapper;
import com.yuwen.pojo.User;
import com.yuwen.service.UserService;
import com.yuwen.utils.CodeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    CodeUtils codeUtils;

    /**
     * 添加注册的用户信息
     * @param user 注册的用户信息
     * @return 是否添加成功
     */
    @Override
    public boolean adduser(User user) {
        return userMapper.addUser(user) > 0;
    }

    /**
     * 生成链接和发送链接
     * @param user 注册的用户信息
     */
    @Override
    public boolean sendCode(User user) {
       if ( codeUtils.sendCode(user)) // 调用验证链接生成工具类中的生成链接和发送邮件函数
           return true;
       else
           return false;
    }

    /**
     * 判断token是否过期
     * @param token 用户注册所接收的token
     * @return 注册成功与否
     */
    @Override
    public boolean eqToken(String token) {
        boolean flag = codeUtils.eqToken(token);

        if (flag){
            User user = codeUtils.findUser(token);
            adduser(user);
            return true;
        }else {
            return false;
        }
    }
}
