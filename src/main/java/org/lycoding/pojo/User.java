package org.lycoding.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data//lombok，在编译阶段，为实体类自动生成getter、setter及toString方法
public class User {
    @NotNull//值不能为null
    private int id;//主键id
    private String username;//用户名
    @JsonIgnore//在springmvc把当前对象转换成json字符串时，忽略转换该字段
    private String password;//密码
    @NotEmpty//值不能为null，且内容不能为空
    @Pattern(regexp = "^.{1,10}$")
    private String nickname;//昵称
    @NotEmpty
    @Email//限定邮箱格式
    private String email;//邮箱
    private String avator;//头像
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
}
