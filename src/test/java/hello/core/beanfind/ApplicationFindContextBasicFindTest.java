package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationFindContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //검증은 assertions로
        //memberService가 MemberServiceImpl의 인스턴스면 성공.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);  //이름 없이 타입으로만 조회 가능.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

//    @Test
//    @DisplayName("구체타입으로 조회")
//    void findBeanByName2(){
//        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
//        //검증은 assertions로
//        //memberService가 MemberServiceImpl의 인스턴스면 성공.
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    //실패 test
    void findBeanByNameX(){
        //MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);

        //오른쪽 로직을 실행하면 왼쪽이 터져야함(안터지면 실패)
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxxx", MemberService.class));
    }


}
