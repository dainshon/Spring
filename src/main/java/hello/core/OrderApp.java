package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        //appconfig에서 꺼내씀
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        //member 생성(회원가입입)
       Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        
        System.out.println("order = " + order); //toString으로 출력됨.
        //ystem.out.println("order.calculatePrice() = " + order.calculatePrice());  //9000원됨.
        
    }
}
