package com.yuwen.service;

import com.yuwen.pojo.User;

public interface UserService {

    // 添加用户
    public boolean adduser(User user);

    // 根据用户注册信息进行注册链接的的生成和发送
    public boolean sendCode(User user);

    // 用户点击注册链接判断token是否过期
    public boolean eqToken(String token);

}
