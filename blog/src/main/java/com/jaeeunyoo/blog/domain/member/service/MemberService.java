package com.jaeeunyoo.blog.domain.member.service;

import com.jaeeunyoo.blog.domain.member.entity.Member;
import com.jaeeunyoo.blog.domain.member.repository.MemberRepository;
import com.jaeeunyoo.blog.exception.ForbiddenException;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private static final DefaultOAuth2UserService DEFAULT_O_AUTH_2_USER_SERVICE = new DefaultOAuth2UserService();

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    public void verifyMember(String githubAccount, Integer githubAccountId) {
        if (githubAccount == null || githubAccountId == null) {
            throw new ForbiddenException();
        }

        Member memberFromDB = memberRepository.findByGithubAccountAndGithubAccountId(githubAccount, githubAccountId);
        if(memberFromDB == null) {
            throw new ForbiddenException();
        }
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = DEFAULT_O_AUTH_2_USER_SERVICE.loadUser(oAuth2UserRequest);
        httpSession.setAttribute("githubAccount", oAuth2User.getAttribute("email"));
        httpSession.setAttribute("githubAccountId", oAuth2User.getAttribute("id"));
        return oAuth2User;
    }
}
