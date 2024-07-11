package org.lycoding.controller;
import org.lycoding.pojo.Article;
import org.lycoding.pojo.Result;
import org.lycoding.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
//    新增文章
    @PostMapping ("/info")
    public Result<String> list(@RequestBody Article article){
        System.out.println("article = " + article);
        return Result.success("Jwt验证成功");
    }
//    自己的文章列表
    @GetMapping("/personList")
    public Result<List> personList(){
    return Result.success(articleService.list());
    }
    //    自己的文章列表
    @GetMapping("/list")
    public Result<List> list(){
    return Result.success("刷新成功！！",articleService.list());
    }
}
