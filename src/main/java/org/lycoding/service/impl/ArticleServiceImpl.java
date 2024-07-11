package org.lycoding.service.impl;

import org.lycoding.mapper.ArticleMapper;
import org.lycoding.pojo.Article;
import org.lycoding.service.ArticleService;
import org.lycoding.utils.ThreadLocalUtil;
import org.lycoding.utils.currentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
//    文章发布
    @Override
    public void publishArticle(Article article) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer createUser = (Integer) map.get("id");
        article.setCreateUser(createUser);
        articleMapper.publishArticle(article);
    }
//    自己的文章列表
    @Override
    public List<Article> list() {
        return articleMapper.list();
    }

    @Override
    public List<Article> personList(Integer createUser) {
        return articleMapper.personList(currentUserUtil.getUserID());
    }
}
