package org.lycoding.controller;

import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.lycoding.pojo.Result;
import org.lycoding.pojo.User;
import org.lycoding.service.impl.UserServiceImpl;
import org.lycoding.utils.JwtUtil;
import org.lycoding.utils.MD5Util;
import org.lycoding.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@Validated//开启正则表达式
@CrossOrigin//跨域
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    //用户注册
    @PostMapping ("/register")
//    正则表达式：5~16个非空字符
    public Result register(@Pattern(regexp = "^.{5,16}$")String username,@Pattern(regexp = "^.{5,16}$")String password) {//@Pattern(regexp = "^.{5,16}$")
        String encryptPassword = MD5Util.encryptMd5(password);
        //用户名没有被占用的情况
        if(userService.findUserByName(username)==null){
            userService.register(username,encryptPassword);
            return Result.success("注册成功!",null);
        }
        else {
            return Result.error("用户名已存在，请换一个~");
        }
    }

    //用户登录
    @PostMapping("/login")
    public Result<String> userLogin(String username,String password){
        User user = userService.findUserByName(username);
        //用户名错误，即用户不存在
        if (user==null){
            return Result.error("用户名不存在!");
        }
        //密码比对正确
        if (user.getPassword().equals(MD5Util.encryptMd5(password))){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",user.getId());
            map.put("username",user.getUsername());
            String token = JwtUtil.genToken(map);
            return Result.success("登录成功！",token);
        }
        return Result.error("密码错误");
    }

    //    获取当前登录用户信息
    @GetMapping("/info")
    public Result<User> getUserInfo(){
        User userInfo = userService.getUserInfoById();
        return Result.success(userInfo);
    }

//    修改当前用户信息
    @PutMapping("/info")
    public Result<String> updateCurrentUser(@RequestParam Map<String,String> map){
        userService.updateCurrentUser(map);
        return Result.success("保存成功","");
    }

//    修改用户密码
    @PatchMapping("/passwd")
    public Result updatePassword(@RequestParam("oldPass") String oldPass,@RequestParam("newPass") String newPass,@RequestParam("confirm") String confirm){

        System.out.println("oldPass = " + oldPass + ", newPass = " + newPass + ", confirm = " + confirm);
        Map<String,Object> threadLocal = ThreadLocalUtil.get();
        String username = (String) threadLocal.get("username");
        User user=userService.findUserByName(username);
        if (!user.getPassword().equals(MD5Util.encryptMd5(oldPass))){
            return Result.error("原密码不正确");
        }
        if (oldPass==null || newPass==null || confirm==null){
            return Result.error("请填写完所有信息");
        }
        if (!newPass.equals(confirm)){
            return Result.error("两次密码填写不一致");
        }
        newPass=MD5Util.encryptMd5(newPass);
        userService.updatePassword(newPass);
        return Result.success("保存成功","");
    }
}
