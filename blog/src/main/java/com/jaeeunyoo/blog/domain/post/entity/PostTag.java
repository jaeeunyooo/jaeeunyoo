package com.jaeeunyoo.blog.domain.post.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jaeeunyoo.blog.domain.tag.entity.Tag;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "post_tag")
public class PostTag {

    @EmbeddedId
    private PostTagKey postTagKey;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId(value = "post_id")
    @JoinColumn(name = "post_id")
    private Post post;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId(value = "tag_id")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public String getTagName() {
        if(this. tag != null) {
            return tag.getTagName();
        }

        return null;
    }

    public static PostTag create(PostTagKey postTagKey, Post post, Tag tag) {
        PostTag postTag = new PostTag();
        postTag.postTagKey = postTagKey;
        postTag.post = post;
        postTag.tag = tag;
        return postTag;
    }
}
