package com.hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {
    @Test
    public void lifecycle(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        System.out.println("getUrl : " + client.getUrl());
//        System.out.println("client = " + client);
//        client.setUrl("테리야ㅏ!!!");
        ac.close();

    }

    @Configuration
//    @ComponentScan
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkCLient = new NetworkClient();
            networkCLient.setUrl("테리야~~");
            return networkCLient;
        }
    }
}
