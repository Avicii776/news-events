package org.lycoding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lycoding.pojo.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
//    发布文章
    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time)"
    +" values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},now(),now())")
    void publishArticle(Article article);
//    管理自己发布的文章
    @Select("select * from article where create_user = #{createUser}")
    List<Article> personList(Integer createUser);

    // 所有文章
    @Select("select * from article")
    List<Article> list();
}
