package com.jaeeunyoo.blog.domain.category.presentation;

import com.jaeeunyoo.blog.domain.category.application.CategoryService;
import com.jaeeunyoo.blog.domain.category.dto.CategoryDetailDto;
import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.tag.application.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final TagService tagService;

    @GetMapping
    public String categories(Model model) {
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "layer/categories";
    }

    @GetMapping("/{categoryId}")
    public String category(Model model, @PathVariable("categoryId") Category category) {
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        model.addAttribute("category", CategoryDetailDto.create(category));
        return "layer/category";
    }
}
