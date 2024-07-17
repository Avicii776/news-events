package org.lycoding.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lycoding.pojo.Notice;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NoticeService {
    //    发布通知
    void addNotice(Notice notice);
    //   查找所有已发布的通知
    List<Notice> list();
    //    删除
    void deleteNotice(Integer id);
//    修改文章分类
}
