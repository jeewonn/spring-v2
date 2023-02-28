package com.hello.core.autowired;

import com.hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }


    static class TestBean {

        @Autowired(required = false)
        // 의존관계가 없으면 해당 메서드 자체가 호출이 안됨.
        public void setNoBean1(Member noBean1){
            // Member => 스프링 컨테이너에서 관리되지 않는것
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        // 호출은 하고, null 로 넣어줌
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);

        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            // Member => 스프링 컨테이너에서 관리되지 않는것
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
