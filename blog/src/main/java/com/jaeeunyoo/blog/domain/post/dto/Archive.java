package com.jaeeunyoo.blog.domain.post.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archive {

    private Integer year;
    private List<PostSummaryDto> posts = new ArrayList<>();
}
