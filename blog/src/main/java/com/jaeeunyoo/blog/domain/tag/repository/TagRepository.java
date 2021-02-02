package com.jaeeunyoo.blog.domain.tag.repository;

import com.jaeeunyoo.blog.domain.post.entity.PostTag;
import com.jaeeunyoo.blog.domain.tag.entity.Tag;
import com.jaeeunyoo.blog.domain.tag.entity.TagIdGettable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    Tag findByTagNameEquals(String tagName);

    List<Tag> findByTagNameIn(List<String> tagNames);

    List<Tag> findByOrderByTagNameAsc();

    List<Tag> findByPostTagsIn(List<PostTag> postTags);

    @Query(
        nativeQuery = true,
        value = "select tag.*, count(post_tag.post_id) as post_count "
            + "from tag tag  "
            + "left join post_tag post_tag on post_tag.tag_id = tag.tag_id "
            + "group by tag.tag_id "
            + "order by post_count desc "
            + "limit 10"
    )
    List<Tag> findAllByQuery();

    List<TagIdGettable> findAllBy();
}
