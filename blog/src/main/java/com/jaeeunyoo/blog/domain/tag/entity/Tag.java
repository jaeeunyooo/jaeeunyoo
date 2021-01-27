package com.jaeeunyoo.blog.domain.tag.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jaeeunyoo.blog.domain.post.entity.PostTag;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(name = "tag_name")
    private String tagName;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "tag")
    private List<PostTag> postTags;

    public static Tag create(String tagName) {
        Tag tag = new Tag();
        tag.tagName = tagName;
        return tag;
    }
}
