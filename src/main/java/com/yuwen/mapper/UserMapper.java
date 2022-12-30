package com.yuwen.mapper;

import com.yuwen.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    // 添加用户 注解开发sql语句
    @Insert("insert into user(account,password,username,address) values (#{account},#{password},#{username},#{address})")
    public int addUser(User user);

}
