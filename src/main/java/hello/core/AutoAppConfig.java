package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan  //@Component 붙은 애들 다 찾아서 자동으로 빈에 등록해줌
        (
                basePackages =  "hello.core.member",    //hello.core.member가 component 대상
                excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)  //얘는 제외
        )
public class AutoAppConfig {

        @Bean(name="memoryMemberRepository")    //같은 이름의 Bean이 중복 등록되는데 Test에서 오류X
        MemberRepository memberRepository(){
                return new MemoryMemberRepository();
        }


}
