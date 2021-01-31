package com.jaeeunyoo.blog.domain.category.dto;

import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.post.dto.PostSummaryDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class CategoryDetailDto {

    private Integer categoryId;
    private String categoryName;
    private List<PostSummaryDto> posts;

    public static CategoryDetailDto create(Category category) {
        CategoryDetailDto dto = new CategoryDetailDto();
        dto.categoryId = category.getCategoryId();
        dto.categoryName = category.getCategoryName();
        dto.posts = category.getPosts().stream().filter(post -> !post.getDeleted()).map(PostSummaryDto::create).collect(Collectors.toList());
        return dto;
    }
}
