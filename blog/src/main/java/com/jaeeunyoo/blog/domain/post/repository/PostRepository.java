package com.jaeeunyoo.blog.domain.post.repository;

import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.post.entity.PostTag;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllBy();

    List<Post> findByDeletedFalseAndPostTagsInOrderByRegisterDateTimeDesc(List<PostTag> postTags);

    PageImpl<Post> findByDeletedFalseOrderByRegisterDateTimeDesc(Pageable pageable);

//    long findCountByDeletedFalseOrderByModifyDateTimeDesc(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT year(post.register_datetime) as y from post post group by year(post.register_datetime) order by y desc")
    List<Integer> findArchiveYears();

    List<Post> findByDeletedFalseOrderByRegisterDateTimeDesc();
}
