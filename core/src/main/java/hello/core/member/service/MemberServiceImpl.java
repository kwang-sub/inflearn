package hello.core.member.service;

import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;
import hello.core.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
