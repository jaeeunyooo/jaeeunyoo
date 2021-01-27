package com.jaeeunyoo.blog.domain.post.dto;

import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.post.entity.PostTag;
import com.jaeeunyoo.blog.util.DateFormatUtil;
import com.jaeeunyoo.blog.util.HtmlUtil;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class PostDetailDto {

    private static final int WORDS_PER_MINUTE = 180;
    private static final String REGEX_BLANK = "\\s+";

    private Integer postId;
    private String postTitle;
    private String postContentHtml;
    private Boolean deleted;
    private String formattedRegisterDayOfMonth;
    private String formattedModifyDayOfMonth;
    private String formattedRegisterMonth;
    private String formattedModifyMonth;
    private String formattedRegisterDate;
    private String formattedModifyDate;
    private String tags;
    private Integer upperCategoryId;
    private Integer categoryId;
    private Integer wordCount;
    private Integer minuteToRead;
    private LocalDateTime registerDateTime;
    private LocalDateTime modifyDateTime;

    public static PostDetailDto create(Post post) {
        PostDetailDto dto = new PostDetailDto();
        dto.postId = post.getPostId();
        dto.postTitle = post.getPostTitle();
        dto.postContentHtml = post.getPostContentHtml();
        dto.wordCount = HtmlUtil.htmlToText(post.getPostContentHtml()).split(REGEX_BLANK).length;
        dto.minuteToRead = dto.wordCount / WORDS_PER_MINUTE;
        dto.deleted = post.getDeleted();
        dto.registerDateTime = post.getRegisterDateTime();
        dto.modifyDateTime = post.getModifyDateTime();
        dto.tags = post.getPostTags() != null ? post.getPostTags()
                                                    .stream()
                                                    .map(PostTag::getTagName)
                                                    .collect(Collectors.joining(",")) : "";
        dto.upperCategoryId = post.getCategory().getUpperCategoryId();
        dto.categoryId = post.getCategory().getCategoryId();
        dto.formattedRegisterDayOfMonth = DateFormatUtil.formatDayOfMonth(post.getRegisterDateTime());
        dto.formattedModifyDayOfMonth = DateFormatUtil.formatDayOfMonth(post.getModifyDateTime());
        dto.formattedRegisterDate = DateFormatUtil.formatDate(post.getRegisterDateTime());
        dto.formattedModifyDate = DateFormatUtil.formatDate(post.getModifyDateTime());
        dto.formattedRegisterMonth = DateFormatUtil.formatMonth(post.getRegisterDateTime());
        dto.formattedModifyMonth = DateFormatUtil.formatMonth(post.getModifyDateTime());
        return dto;
    }
}
