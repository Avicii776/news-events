package org.lycoding.service.impl;

import org.lycoding.mapper.UserMapper;
import org.lycoding.pojo.User;
import org.lycoding.service.UserService;
import org.lycoding.utils.ThreadLocalUtil;
import org.lycoding.utils.currentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    //自动装配一个usermapper对象
    @Autowired
    private UserMapper userMapper;

    //  按用户名查找用户
    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
    //注册用户
    public void register(String username, String password){
       userMapper.register(username,password);
    }


//      修改用户密码
    @Override
    public void updatePassword(String newPassword) {
        Map<String, Object> threadLocal = ThreadLocalUtil.get();
        Integer id = (Integer) threadLocal.get("id");
        userMapper.updatePassword(newPassword,id);
    }

//     修改当前用户信息
    public void updateCurrentUser(Map<String,String> map){
        User user = new User();
        user.setNickname(map.get("nickname"));
        user.setEmail(map.get("email"));
        user.setAvator(map.get("avator"));
        user.setId(currentUserUtil.getUserID());
        System.out.println("user = " + user);
        userMapper.updateCurrentUser(user);
    }

//    获取当前登录用户信息
    public User getUserInfoById() {
        Integer id = currentUserUtil.getUserID();
        User userInfo = userMapper.getUserInfoById(id);
        return userInfo;
    }
}
