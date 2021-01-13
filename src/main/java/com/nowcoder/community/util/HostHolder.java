package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/*
* 持有用户信息，用于代替session对象
* */

@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }  // 实现线程隔离

    public User getUser(){
        return users.get();
    } // 以线程为key，存取值

    public void clear(){
        users.remove();
    }
}

// threadLocal实现线程隔离，以线程为key，存取值
