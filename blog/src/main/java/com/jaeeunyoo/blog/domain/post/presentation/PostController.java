package com.jaeeunyoo.blog.domain.post.presentation;

import com.jaeeunyoo.blog.domain.category.application.CategoryService;
import com.jaeeunyoo.blog.domain.member.service.MemberService;
import com.jaeeunyoo.blog.domain.post.application.PostService;
import com.jaeeunyoo.blog.domain.post.dto.PostDetailDto;
import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.tag.application.TagService;
import com.jaeeunyoo.blog.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class PostController {

    private final PostService postService;
    private final TagService tagService;
    private final CategoryService categoryService;
    private final MemberService memberService;

    @Value("url")
    private String url;

    @GetMapping("/")
    public String home(Model model, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        model.addAttribute("postPage", postService.getRecentPostPage(pageable));
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        return "layer/posts";
    }

    @GetMapping("/archive")
    public String archives(Model model, @PageableDefault(page = 0, size = 100) Pageable pageable) {
        model.addAttribute("archives", postService.getArchives());
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        return "layer/archives";
    }

    @GetMapping("/post/{postId}")
    public String post(Model model, @PathVariable("postId") Post post) {
        if(post == null) {
            throw new NotFoundException();
        }

        model.addAttribute("url", url);
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        model.addAttribute("categories", post.getCategory().getCategoriesIncludeUpperCategory());
        model.addAttribute("postTags", tagService.getPostTags(post));
        model.addAttribute("post", PostDetailDto.create(post));
        return "layer/post";
    }

    @GetMapping("/new")
    public String newPost(Model model,
                          @AuthenticationPrincipal OAuth2User principal) {
        memberService.verifyMember(principal);
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "layer/edit";
    }

    @GetMapping("/post/{postId}/edit")
    public String editPost(Model model,
                           @PathVariable("postId") Post post,
                           @AuthenticationPrincipal OAuth2User principal) {
        memberService.verifyMember(principal);
        if(post == null) {
            throw new NotFoundException();
        }

        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("post", PostDetailDto.create(post));
        return "layer/edit";
    }
}
