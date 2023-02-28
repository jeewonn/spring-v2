package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10프로 할인이 적용")
    void vip_o(){
        Member member = new Member(1L, "memberA", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("vip가 아니면 할인 적용 되지 않아야함.")
    void vip_x(){
        Member memberB = new Member(2L, "memberB", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(memberB, 10000);

        assertThat(discount).isEqualTo(0);
    }

}