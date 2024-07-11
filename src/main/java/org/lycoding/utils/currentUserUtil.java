package org.lycoding.utils;

import java.util.Map;

public class currentUserUtil {
//    返回当前用户的id
    public static Integer getUserID(){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer)map.get("id");
        return id;
    }
//返回当前用户用名
    public static String getUserName(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        return username;
    }
}
