package com.jaeeunyoo.blog.domain.post.repository;

import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.post.entity.PostTag;
import com.jaeeunyoo.blog.domain.post.entity.PostTagKey;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostTagRepository extends CrudRepository<PostTag, PostTagKey> {

    List<PostTag> findByPost(Post post);
}
