package org.lycoding.mapper;

import org.apache.ibatis.annotations.*;
import org.lycoding.pojo.Notice;
import org.lycoding.pojo.Notice;

import java.util.List;

@Mapper
public interface NoticeMapper {
//    发布通知
    @Insert("insert into notice(publish_title,publish_content,publish_user,publish_state,publish_time)"
    +" value(#{publishTitle},#{publishContent},#{publishUser},#{publishState},now())")
    void addNotice(Notice notice);
//
    @Select("select * from Notice where publish_state=1")
    List<Notice> list();
//    删除
    @Delete("delete from Notice where id = #{id}")
    void deleteNotice(Integer id);
//    修改文章分类
    @Update("update Notice set Notice_name=#{NoticeName},Notice_alias=#{NoticeAlias},update_time=now() where id=#{id}")
    void updateNotice(Notice Notice);
}
