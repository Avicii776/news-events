package org.lycoding.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.lycoding.pojo.Category;

import java.util.List;

public interface CategoryService {
//    新增文章分类
    void addCategory(Category category);
//    按分类名查找分类信息
    Category findByCategoryName(String categoryName);
//    文章分类列表
    List<Category> list();
    //    删除
    void deleteCategory(Integer id);
//修改
    void updateCategory(Category category);
}
