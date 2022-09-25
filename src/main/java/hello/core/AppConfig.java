package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//AppConfig에서 실제 동작에 필요한 구현 객체 생성
//AppConfig는 공연 기획자
@Configuration
public class AppConfig {
    //App의 구성, 설정 정보에 @Configuration
    //@Bean은 컨테이너에 등록됨.

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }
    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        //생성자 이용
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
