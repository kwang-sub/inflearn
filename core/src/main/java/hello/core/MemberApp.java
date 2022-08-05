package hello.core;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService service = applicationContext.getBean(MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        service.join(member);

        Member findMember = service.findMember(member.getId());

        System.out.println("new member : " + member.getName());
        System.out.println("find member : " + findMember.getName());

    }
}
