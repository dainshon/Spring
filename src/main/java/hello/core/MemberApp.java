package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    private static MemberRepository memberRepository;

    public static void main(String[] args) {    //psvm 치고 엔터누르면됨.싱기
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //얘가 spring container
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //"memberService"가 이름, MemberService는 타입.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());   //soutv 엔터
        System.out.println("findMember = " + findMember.getName());

    }
}
