package hello.core.member.repository;

import hello.core.member.domain.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
