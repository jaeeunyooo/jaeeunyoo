package com.jaeeunyoo.blog.domain.about;

import com.jaeeunyoo.blog.domain.tag.application.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AboutController {

    private final TagService tagService;

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        return "layer/about";
    }
}
