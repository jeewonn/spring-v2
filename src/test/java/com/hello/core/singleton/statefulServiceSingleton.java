package com.hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class statefulServiceSingleton {
//    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class)

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // 사용자 a 1만원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        // 사용자 b 2만원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // 사용자 a 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);

        Assertions.assertThat(userBPrice).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() { return new StatefulService(); }

    }

}
