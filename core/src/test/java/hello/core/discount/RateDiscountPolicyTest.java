package hello.core.discount;

import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다")
    void vip_o() {
        Member member = new Member(1L, "vip", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 10_000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        Member member = new Member(1L, "bagic", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(member, 10_000);
        assertThat(discount).isEqualTo(0);
    }
}