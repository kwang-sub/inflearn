package hello.core.discount;

import hello.core.member.domain.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
