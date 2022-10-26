package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.repository.MemberRepository;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void configurationTest() {
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
    }

    @Test
    void configurationDeep() {
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println(bean.getClass());
    }
}
