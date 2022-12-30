package com.yuwen.controller;

import com.yuwen.pojo.User;
import com.yuwen.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    UserService userService;

    // 根据用户注册信息进行注册链接的的生成和发送
    @PostMapping("/sendCode")
    public Map<String,String> sendCode(@RequestBody User user){
        boolean flag = userService.sendCode(user);
        Map<String,String> map = new HashMap<>();
        if(flag){
            map.put("msg","邮件发送成功，请前往您的邮箱进行注册验证");
            return map;
        }else {
            map.put("msg","邮件发送失败");
            return map;
        }
    }

    // 判断是否注册成功
    @GetMapping("/lookCode/{token}")
    public Map<String,String> lookCode(@PathVariable("token")String token){
        boolean flag = userService.eqToken(token);
        Map<String,String> map = new HashMap<>();
        if (flag){
            map.put("msg","注册成功");
            /* 后续的操作 ... ...*/
            return map;
        }else {
            map.put("msg","注册码过期，请重新注册");
            return map;
        }
    }
}
