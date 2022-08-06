package hello.core.order.service;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;
import hello.core.order.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;

class OrderServiceImplTest {
    MemberRepository memberRepository;
    DiscountPolicy discountPolicy;
    @BeforeEach
    void setup() {
        Member member = new Member(1L, "name", Grade.VIP);
        memberRepository = mock(MemoryMemberRepository.class);
        given(memberRepository.findById(1L)).willReturn(member);


        discountPolicy = mock(RateDiscountPolicy.class);
        given(discountPolicy.discount(member, 10000)).willReturn(1000);
    }

    @Test
    void createOrder() {
//        MemberRepository memberRepository = new MemoryMemberRepository();
//        memberRepository.save(new Member(1L, "name", Grade.VIP));
//        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        Order itemA = orderService.createOrder(1L, "itemA", 10000);
        System.out.println(itemA);
    }

}