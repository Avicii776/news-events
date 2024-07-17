package org.lycoding.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class Notice {
    private Integer id;
    private String publishTitle;//通知标题
    private String publishContent;//通知内容
    private String publishUser;
    private boolean publishState;  //发布状态，判断是否发布
    private Date publishTime;

}
