package org.lycoding.utils;

public class ThreadLocalUtil {
//    维护一个全局唯一的threadlocal对象
    private static final ThreadLocal THREAD_LOCAL=new ThreadLocal();
//根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }
//    存储键值对
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }
//    清除ThreadLocal,防止内存泄露，因为ThreadLocal的生命周期特别长
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
