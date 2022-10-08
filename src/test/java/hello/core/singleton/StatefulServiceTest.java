package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        
        //ThreadA: A사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB: B사용자가 20000원 주문
        statefulService2.order("userB", 20000);
        
        //ThreadA: 사용자 A가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);
        //B 사용자 난입 후 조회해서 20000원 나옴.(같은 instance를 사용하기떄문)

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    
    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }

}