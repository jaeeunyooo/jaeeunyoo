package com.jaeeunyoo.blog.domain.post.application;

import com.jaeeunyoo.blog.config.cache.CacheKey;
import com.jaeeunyoo.blog.domain.post.dto.SimpleJekyllSearchResult;
import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.post.dto.Archive;
import com.jaeeunyoo.blog.domain.post.dto.PostSummaryDto;
import com.jaeeunyoo.blog.domain.post.entity.PostTag;
import com.jaeeunyoo.blog.domain.post.entity.PostTagKey;
import com.jaeeunyoo.blog.domain.post.repository.PostRepository;
import com.jaeeunyoo.blog.domain.post.repository.PostTagRepository;
import com.jaeeunyoo.blog.domain.tag.entity.Tag;
import com.jaeeunyoo.blog.exception.NotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostTagRepository postTagRepository;

    public PageImpl<PostSummaryDto> getRecentPostPage(Pageable pageable) {
        PageImpl<Post> postPage = postRepository.findByDeletedFalseOrderByRegisterDateTimeDesc(pageable);
        return new PageImpl<>(PostSummaryDto.createMany(postPage.getContent()), pageable, postPage.getTotalElements());
    }

    public List<Archive> getArchives() {
        List<Integer> archiveYears = postRepository.findArchiveYears();
        List<Post> allPosts = postRepository.findByDeletedFalseOrderByRegisterDateTimeDesc();
        if (allPosts == null || allPosts.isEmpty()) {
            return Collections.emptyList();
        }

        List<Archive> archives = new ArrayList<>();
        for(Integer year : archiveYears) {
            Archive archive = new Archive();
            archive.setYear(year);
            for(Post post : allPosts) {
                if(year.equals(post.getRegisterDateTime().getYear())) {
                    archive.getPosts().add(PostSummaryDto.create(post));
                }
            }
            archives.add(archive);
        }
        return archives;
    }

    public List<PostSummaryDto> getTaggedPosts(Tag tag) {
        return PostSummaryDto.createMany(postRepository.findByDeletedFalseAndPostTagsInOrderByRegisterDateTimeDesc(tag.getPostTags()));
    }

    @Cacheable(value = CacheKey.KEY_ALL_POSTS)
    public List<SimpleJekyllSearchResult> getAllSimpleJekyllSearchResults() {
        return postRepository.findByDeletedFalseOrderByRegisterDateTimeDesc().stream().map(SimpleJekyllSearchResult::create).collect(Collectors.toList());
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Post getPost(Integer postId) {
        return postRepository.findById(postId).orElseThrow(NotFoundException::new);
    }

    public void savePostTags(List<Tag> tags, Post post) {
        List<PostTag> postTags = postTagRepository.findByPost(post);
        if(postTags != null && !postTags.isEmpty()) {
            postTagRepository.deleteAll(postTags);
        }

        if(tags != null && !tags.isEmpty()) {
            tags.forEach(tag -> {
                postTagRepository.save(PostTag.create(PostTagKey.create(post.getPostId(), tag.getTagId()), post, tag));
            });
        }
    }
}
