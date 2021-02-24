package com.lhb.community.util;

import com.lhb.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author littlelee
 * @date 2020/12/19 17:22
 * 持有用户信息，用于代替session对象
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }

}
