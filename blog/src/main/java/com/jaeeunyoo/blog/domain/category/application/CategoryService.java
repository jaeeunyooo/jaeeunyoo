package com.jaeeunyoo.blog.domain.category.application;

import com.jaeeunyoo.blog.domain.category.dto.RootCategoryDto;
import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.category.repository.CategoryRepository;
import com.jaeeunyoo.blog.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<RootCategoryDto> getAllCategories() {
        return categoryRepository.findByUpperCategoryIdEquals(0).stream().map(RootCategoryDto::create).collect(Collectors.toList());
    }

    public Category getCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(NotFoundException::new);
    }
}
