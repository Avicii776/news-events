package org.lycoding.service;

import org.lycoding.pojo.User;
import org.lycoding.utils.currentUserUtil;

import java.util.Map;

public interface UserService {
//    按用户名查找用户
    User findUserByName(String username);

//    注册用户
    void register(String username, String password);


//   修改用户密码
    void updatePassword(String newPassword);

//     修改当前用户信息
    void updateCurrentUser(Map<String,String> map);

//    获取当前登录用户头像url
    public User getUserInfoById();
}
