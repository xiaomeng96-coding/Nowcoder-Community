package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper  // Mapper接口，不需要实现类，定义增删改查的方法
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);  // User对象

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
// 接口中的增删改查的方法
