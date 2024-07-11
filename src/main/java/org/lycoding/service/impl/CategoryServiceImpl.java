package org.lycoding.service.impl;

import jdk.jfr.Threshold;
import org.lycoding.mapper.CategoryMapper;
import org.lycoding.pojo.Category;
import org.lycoding.service.CategoryService;
import org.lycoding.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
//    添加文章分类
    @Override
    public void addCategory(Category category) {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        category.setCreateUser(id);
        categoryMapper.addCategory(category);
    }
//    按分类名查找分类信息
    @Override
    public Category findByCategoryName(String categoryName) {
        return categoryMapper.findByCategoryName(categoryName);
    }
//    文章分类列表
    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }
//    删除
    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
    }
//   修改
    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }
}
