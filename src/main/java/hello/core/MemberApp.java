package hello.core;

import hello.core.member.*;

public class MemberApp {

    private static MemberRepository memberRepository;

    public static void main(String[] args) {    //psvm 치고 엔터누르면됨.싱기
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());   //soutv 엔터
        System.out.println("findMember = " + findMember.getName());

    }
}
