package com.hello.core.autowired;

import com.hello.core.AutoAppConfig;
import com.hello.core.discount.DiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {
    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

    }

    static class DiscountService{
        private final DiscountPolicy discountPolicy1;
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(DiscountPolicy discountPolicy1, Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.discountPolicy1 = discountPolicy1;
            this.policyMap = policyMap;
            this.policyList = policyList;

            System.out.println("discountPolicy1 = " + discountPolicy1);
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String fixDiscountPolicy) {
            DiscountPolicy discountPolicy = policyMap.get(fixDiscountPolicy);
            return discountPolicy.discount(member, price);
        }
    }

}
