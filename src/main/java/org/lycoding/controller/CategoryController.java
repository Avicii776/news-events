package org.lycoding.controller;

import org.lycoding.pojo.Category;
import org.lycoding.pojo.Result;
import org.lycoding.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;
//    新增文章分类
    @PostMapping("/add")
    public Result addCategory( @Validated Category category){
        String categoryName = category.getCategoryName();
        Category byCategoryName = categoryService.findByCategoryName(categoryName);
        if (byCategoryName ==null){
            categoryService.addCategory(category);
            return Result.success("添加成功",null);
        }
        else if (category.getCategoryName()==null&&category.getCategoryAlias()==null) {
            Result.error("分类名不能为空");
        } else {
            return Result.error("分类名已存在");
        }
        return Result.error("分类名已存在");
    }
//    文章分类列表
    @GetMapping("/list")
    public Result<List> list(){
        List<Category> list = categoryService.list();
        return Result.success("",list);
    }
//    删除
    @DeleteMapping("delete")
    public Result<String> deleteCategory(Integer id){
        categoryService.deleteCategory(id);
        return Result.success("删除成功",null);
    }

    @PutMapping("update")
   public Result updateCategory(@Validated Category category){
        categoryService.updateCategory(category);
        return Result.success("修改成功",null);
    }
}
