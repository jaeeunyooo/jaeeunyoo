package com.jaeeunyoo.blog.domain.tag.dto;

import com.jaeeunyoo.blog.domain.post.dto.PostSummaryDto;
import com.jaeeunyoo.blog.domain.tag.entity.Tag;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class TagDto implements Serializable {

    private Integer tagId;
    private String tagName;
    private List<PostSummaryDto> taggedPosts;

    public static TagDto create(Tag tag) {
        TagDto dto = new TagDto();
        dto.tagId = tag.getTagId();
        dto.tagName = tag.getTagName();
        dto.taggedPosts = tag.getPostTags()
                             .stream()
                             .filter(postTag -> !postTag.getPost().getDeleted())
                             .map(postTag -> PostSummaryDto.create(postTag.getPost()))
                             .collect(Collectors.toList());
        return dto;
    }

    public static List<TagDto> createMany(List<Tag> tags) {
        if(tags == null || tags.isEmpty()) {
            return Collections.emptyList();
        }

        return tags.stream().map(TagDto::create).collect(Collectors.toList());
    }
}
