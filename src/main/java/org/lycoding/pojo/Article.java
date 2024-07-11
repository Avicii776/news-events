package org.lycoding.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Article {
    private Integer id;//文章id
    private String title;//标题
    private String content;//内容
    private String coverImg;//图片
    private String state;//状态：已发布/草稿
    private Integer categoryId;//分类id
    private Integer createUser;//发布人id
    private Date createTime;////创建时间
    private Date updateTime;//更新时间
}
