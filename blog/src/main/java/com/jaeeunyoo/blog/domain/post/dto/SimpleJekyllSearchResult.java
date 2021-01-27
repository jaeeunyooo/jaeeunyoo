package com.jaeeunyoo.blog.domain.post.dto;

import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.post.entity.PostTag;
import com.jaeeunyoo.blog.util.DateFormatUtil;
import com.jaeeunyoo.blog.util.HtmlUtil;
import java.io.Serializable;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class SimpleJekyllSearchResult implements Serializable {

    private String url;
    private String title;
    private String snippet;
    private String date;
    private String tags;
    private String categories;

    public static SimpleJekyllSearchResult create(Post post) {
        SimpleJekyllSearchResult dto = new SimpleJekyllSearchResult();
        dto.url = "/post/" + post.getPostId();
        dto.title = post.getPostTitle();
        dto.snippet = HtmlUtil.htmlToText(post.getPostContentHtml());
        dto.date = DateFormatUtil.formatDate(post.getModifyDateTime());
        dto.tags = post.getPostTags() != null && !post.getPostTags().isEmpty() ?
            post.getPostTags().stream().map(PostTag::getTagName).collect(Collectors.joining(", ")) :
            " ";
        dto.categories = post.getCategory().getCategoryName();
        return dto;
    }
}
