package org.lycoding.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;//文章分类id
    @NotEmpty
    private String categoryName;//文章分类名称
    @NotEmpty
    private String categoryAlias;//文章分类别名
    private Integer createUser;//创建人id
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
}
