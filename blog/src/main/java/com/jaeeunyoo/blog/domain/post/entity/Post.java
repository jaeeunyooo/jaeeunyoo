package com.jaeeunyoo.blog.domain.post.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.post.dto.PostEditDto;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content_html")
    private String postContentHtml;

    @Column(name = "post_content_md")
    private String postContentMd;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "register_member_id")
    private Integer registerMemberId;

    @Column(name = "register_datetime", nullable = false)
    private LocalDateTime registerDateTime;

    @Column(name = "modify_member_id")
    private Integer modifyMemberId;

    @Column(name = "modify_datetime")
    private LocalDateTime modifyDateTime;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "post")
    private List<PostTag> postTags;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = true, updatable = true)
    private Category category;

    public static Post create(PostEditDto postEditDto, Category category) {
        Post post = new Post();
        post.postTitle = postEditDto.getPostTitle();
        post.postContentHtml = postEditDto.getPostContentHtml();
        post.postContentMd = postEditDto.getPostContentMd();
        post.deleted = false;
        post.category = category;
        post.registerDateTime = LocalDateTime.now();
        post.registerMemberId = 1;
        post.modifyDateTime = LocalDateTime.now();
        post.modifyMemberId = 1;
        post.postTags = Collections.emptyList();
        return post;
    }

    public void modify(PostEditDto postEditDto, Category category) {
        this.postTitle = postEditDto.getPostTitle();
        this.postContentHtml = postEditDto.getPostContentHtml();
        this.postContentMd = postEditDto.getPostContentMd();
        this.modifyDateTime = LocalDateTime.now();
        this.category = category;
    }
}
