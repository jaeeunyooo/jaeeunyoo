package com.jaeeunyoo.blog.domain.category.dto;

import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.post.dto.PostSummaryDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class RootCategoryDto extends SubCategoryDto {

    private Integer categoryId;
    private String categoryName;
    private List<PostSummaryDto> posts;
    private List<SubCategoryDto> subCategories;

    public static RootCategoryDto create(Category category) {
        RootCategoryDto dto = new RootCategoryDto();
        dto.categoryId = category.getCategoryId();
        dto.categoryName = category.getCategoryName();
        dto.posts = category.getPosts().stream().filter(post -> !post.getDeleted()).map(PostSummaryDto::create).collect(Collectors.toList());
        if(category.getSubCategories() != null) {
            dto.subCategories = category.getSubCategories().stream().map(SubCategoryDto::create).collect(Collectors.toList());
        }
        return dto;
    }
}
