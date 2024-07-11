package org.lycoding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lycoding.pojo.User;

import java.util.Map;

@Mapper
public interface UserMapper {
    //按用户名查找用户
    @Select("select * from user where username = #{username}")
    User findUserByName(String username);

    //注册用户
    @Insert("insert into user(username,password,create_time,update_time) values(#{username},#{password},now(),now())")
    void register(String username,String password);


//    修改用户密码
    @Update("update user set password=#{newPassword} where id=#{id}")
    void updatePassword(String newPassword, Integer id);

//     修改当前用户信息
    @Update("update user set nickname=#{nickname},email=#{email},avator=#{avator},update_time=now() where id=#{id}")
    void updateCurrentUser(User currentUser);

//    获取当前已登录用户的详细信息
    @Select("select id,username,nickname,avator,email from user where id = #{id}")
    public User getUserInfoById(Integer id);
}

