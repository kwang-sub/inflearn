package hello.core.member;

import hello.core.AppConfig;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class MemberServiceImplTest {


    MemberService memberService;

    @BeforeEach
    public void setup() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = ac.getBean(MemberService.class);
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());
        //then
        assertThat(member).isEqualTo(findMember);
    }
}