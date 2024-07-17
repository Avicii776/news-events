package org.lycoding.controller;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.lycoding.pojo.Article;
import org.lycoding.pojo.Result;
import org.lycoding.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
//    发布文章
    /*
        接收前端发来的请求参数时不需要使用RequestBody注解了，他妈的
     */
    @PostMapping ("/info")
    public Result<String> articleList(Article article){
        articleService.publishArticle(article);
        return Result.success("发布成功",null);
    }
//    自己的文章列表
    @GetMapping("/personList")
    public Result<List> personList(){
    return Result.success(articleService.list());
    }
//    所有的文章列表
    @GetMapping("/list")
    public Result<List> list(){
    return Result.success("刷新成功！！",articleService.list());
    }
}


 
