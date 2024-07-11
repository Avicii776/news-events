package org.lycoding.service;

import org.lycoding.pojo.Article;

import java.util.List;

public interface ArticleService {
//    文章发布
    void publishArticle(Article article);
//    文章列表
    List<Article> list();

    //    自己文章列表
    List<Article> personList(Integer createUser);



}
