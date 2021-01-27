package com.jaeeunyoo.blog.domain.member.presentation;

import com.jaeeunyoo.blog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/sign-in")
    public String login(@AuthenticationPrincipal OAuth2User principal) {
        memberService.verifyMember(principal);
        return "layer/login";
    }
}
