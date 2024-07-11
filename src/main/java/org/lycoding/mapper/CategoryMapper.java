package org.lycoding.mapper;

import org.apache.ibatis.annotations.*;
import org.lycoding.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
//    按分类名查找
    @Select("select * from category where category_name=#{categoryName}")
    Category findByCategoryName(String categoryName);
//    新增文章分类
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time)"
    +" value(#{categoryName},#{categoryAlias},#{createUser},now(),now())")
    void addCategory(Category category);
//    文章分类列表
    @Select("select * from category")
    List<Category> list();
//    删除
    @Delete("delete from category where id = #{id}")
    void deleteCategory(Integer id);
//    修改文章分类
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=now() where id=#{id}")
    void updateCategory(Category category);
}
