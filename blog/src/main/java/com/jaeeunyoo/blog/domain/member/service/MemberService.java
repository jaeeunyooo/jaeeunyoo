package com.jaeeunyoo.blog.domain.member.service;

import com.jaeeunyoo.blog.domain.member.entity.Member;
import com.jaeeunyoo.blog.domain.member.repository.MemberRepository;
import com.jaeeunyoo.blog.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void verifyMember(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null || principal.getAttribute("id") == null || principal.getAttribute("email") == null) {
            throw new ForbiddenException();
        }

        Integer githubAccountId = principal.getAttribute("id");
        String githubAccount = principal.getAttribute("email");
        Member member = memberRepository.findByGithubAccountAndGithubAccountId(githubAccount, githubAccountId);
        if(member == null) {
            throw new ForbiddenException();
        }
    }
}
