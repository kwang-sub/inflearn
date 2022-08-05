package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.domain.Order;
import hello.core.order.service.OrderService;
import hello.core.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {



    MemberService memberService ;
    OrderService orderService;

    @BeforeEach
    public void setup() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = ac.getBean(MemberService.class);
        orderService = ac.getBean(OrderService.class);
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "mem", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "아이템", 20_000);
        assertThat(order.getDiscountPrice()).isEqualTo(2_000);
    }
}
