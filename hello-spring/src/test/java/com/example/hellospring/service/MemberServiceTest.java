package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    MemoryMemberRepository repository;
    MemberService memberService;

    @BeforeEach
    public void setUp() {
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void after() {
        repository.clearStore();
    }
    
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("hello");
        Member member2 = new Member();
        member2.setName("hello");
        //when
        memberService.join(member1);
        //then
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}