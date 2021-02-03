package com.jaeeunyoo.blog.domain.post.dto;

import java.util.List;
import lombok.Data;

@Data
public class PostEditDto {

    private Integer postId;
    private String postTitle;
    private String postContentHtml;
    private String postContentMd;
    private Integer categoryId;
    private List<String> tags;
}
