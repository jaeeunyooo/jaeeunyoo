package com.jaeeunyoo.blog.domain.post.dto;

import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.util.DateFormatUtil;
import com.jaeeunyoo.blog.util.HtmlUtil;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class PostSummaryDto implements Serializable {

    private static final int WORDS_PER_MINUTE = 180;
    private static final String REGEX_BLANK = "\\s+";

    private Integer postId;
    private String postTitle;
    private String postContent;
    private Boolean deleted;
    private String formattedRegisterDayOfMonth;
    private String formattedModifyDayOfMonth;
    private String formattedRegisterMonth;
    private String formattedModifyMonth;
    private String formattedRegisterDate;
    private String formattedModifyDate;
    private Integer wordCount;
    private Integer minuteToRead;
    private LocalDateTime registerDateTime;
    private LocalDateTime modifyDateTime;

    public static PostSummaryDto create(Post post) {
        PostSummaryDto dto = new PostSummaryDto();
        dto.postId = post.getPostId();
        dto.postTitle = post.getPostTitle();
        dto.postContent = HtmlUtil.htmlToText(post.getPostContentHtml());
        dto.wordCount = dto.postContent.split(REGEX_BLANK).length;
        dto.minuteToRead = dto.wordCount / WORDS_PER_MINUTE;
        dto.deleted = post.getDeleted();
        dto.registerDateTime = post.getRegisterDateTime();
        dto.modifyDateTime = post.getModifyDateTime();
        dto.formattedRegisterDayOfMonth = DateFormatUtil.formatDayOfMonth(post.getRegisterDateTime());
        dto.formattedModifyDayOfMonth = DateFormatUtil.formatDayOfMonth(post.getModifyDateTime());
        dto.formattedRegisterDate = DateFormatUtil.formatDate(post.getRegisterDateTime());
        dto.formattedModifyDate = DateFormatUtil.formatDate(post.getModifyDateTime());
        dto.formattedRegisterMonth = DateFormatUtil.formatMonth(post.getRegisterDateTime());
        dto.formattedModifyMonth = DateFormatUtil.formatMonth(post.getModifyDateTime());
        return dto;
    }

    public static List<PostSummaryDto> createMany(List<Post> posts) {
        if(posts == null || posts.isEmpty()) {
            return Collections.emptyList();
        }

        return posts.stream().map(PostSummaryDto::create).collect(Collectors.toList());
    }
}
