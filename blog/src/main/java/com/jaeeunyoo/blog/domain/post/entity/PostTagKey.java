package com.jaeeunyoo.blog.domain.post.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PostTagKey implements Serializable {

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "tag_id")
    private Integer tagId;

    public static PostTagKey create(Integer postId, Integer tagId) {
        PostTagKey postTagKey = new PostTagKey();
        postTagKey.postId = postId;
        postTagKey.tagId = tagId;
        return postTagKey;
    }
}
