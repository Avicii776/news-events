package org.lycoding.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义返回信息格式--json格式
 */
@NoArgsConstructor//lombok提供，编译阶段生成实体类的无参构造方法
@AllArgsConstructor//lombok提供，编译阶段生成实体类的全参构造方法
@Data//使用该注解提供getter、setter、toString方法，让框架自动将Result对象转化成json字符串
public class Result<T> {
    private Integer code;//业务状态码，0成功，1失败
    private String message;//提示信息
    private T data;//响应数据，泛型T，

    //快速返回操作成功响应结果（带响应数据）
    public static <E> Result<E> success(E data){
        return new Result<>(0,"操作成功",data);
    }

    public static <E> Result<E> success(String message,E data){
        return new Result<>(0,message,data);
    }

    //快速返回操作成功响应结果
    public static Result success(){
        return new Result(0,"操作成功",null);
    }
    //快速返回操作失败响应结果
    public static Result error(String message){
        return new Result(1,message,null);
    }
}
