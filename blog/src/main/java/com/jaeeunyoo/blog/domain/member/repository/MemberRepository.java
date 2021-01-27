package com.jaeeunyoo.blog.domain.member.repository;

import com.jaeeunyoo.blog.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByGithubAccountAndGithubAccountId(String githubAccount, Integer githubAccountId);
}
