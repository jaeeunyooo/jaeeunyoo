package com.jaeeunyoo.blog.domain.category.dto;

import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.post.dto.PostSummaryDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class SubCategoryDto {

    private Integer categoryId;
    private String categoryName;
    private List<PostSummaryDto> posts;

    public static SubCategoryDto create(Category category) {
        SubCategoryDto dto = new SubCategoryDto();
        dto.categoryId = category.getCategoryId();
        dto.categoryName = category.getCategoryName();
        dto.posts = category.getPosts().stream().map(PostSummaryDto::create).collect(Collectors.toList());
        return dto;
    }
}
