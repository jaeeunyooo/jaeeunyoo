package com.jaeeunyoo.blog.domain.tag.presentation;

import com.jaeeunyoo.blog.domain.post.application.PostService;
import com.jaeeunyoo.blog.domain.tag.application.TagService;
import com.jaeeunyoo.blog.domain.tag.entity.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;
    private final PostService postService;

    @GetMapping
    public String tags(Model model) {
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        model.addAttribute("tags", tagService.getAllTags());
        return "layer/tags";
    }

    @GetMapping("{tagId}")
    public String tag(Model model, @PathVariable("tagId") Tag tag) {
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        model.addAttribute("tag", tag);
        model.addAttribute("taggedPosts", postService.getTaggedPosts(tag));
        return "layer/tag";
    }
}
