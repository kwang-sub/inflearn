package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.domain.Order;
import hello.core.order.service.OrderService;
import hello.core.order.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "member", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "테스트아이템", 10_000);

        System.out.println(order);
    }
}
