package com.jaeeunyoo.blog.domain.category.repository;

import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.category.entity.CategoryIdGettable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByUpperCategoryIdEquals(Integer upperCategoryId);

    List<CategoryIdGettable> findAllBy();
}
