package com.jaeeunyoo.blog.domain.post.presentation;

import com.jaeeunyoo.blog.domain.category.application.CategoryService;
import com.jaeeunyoo.blog.domain.category.entity.Category;
import com.jaeeunyoo.blog.domain.post.application.PostService;
import com.jaeeunyoo.blog.domain.post.dto.PostEditDto;
import com.jaeeunyoo.blog.domain.post.dto.PostSummaryDto;
import com.jaeeunyoo.blog.domain.post.dto.SimpleJekyllSearchResult;
import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.tag.application.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostRestController {

    private final PostService postService;
    private final TagService tagService;
    private final CategoryService categoryService;

    @GetMapping("/recent")
    public PageImpl<PostSummaryDto> recentPosts(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return postService.getRecentPostPage(pageable);
    }

    @GetMapping("/{postId}")
    public Post post(Model model, @PathVariable("postId") Post post) {
        return post;
    }

    @GetMapping("/all")
    public List<SimpleJekyllSearchResult> searchPosts() {
        return postService.getAllSimpleJekyllSearchResults();
    }

    @PostMapping
    public Integer createPost(@RequestBody PostEditDto postEditDto) {
        tagService.saveNewTags(postEditDto.getTags());
        Category category = categoryService.getCategory(postEditDto.getCategoryId());
        Post post = Post.create(postEditDto, category);
        postService.savePost(post);
        postService.savePostTags(tagService.getTagsByTagNames(postEditDto.getTags()), post);
        return post.getPostId();
    }

    @PutMapping
    public Integer modifyPost(@RequestBody PostEditDto postEditDto) {
        Post post = postService.getPost(postEditDto.getPostId());
        Category category = categoryService.getCategory(postEditDto.getCategoryId());
        post.modify(postEditDto, category);
        tagService.saveNewTags(postEditDto.getTags());
        postService.savePost(post);
        postService.savePostTags(tagService.getTagsByTagNames(postEditDto.getTags()), post);
        return post.getPostId();
    }
}
