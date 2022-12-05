package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy  //이렇게 어노테이션 만들어서 쓰기도 가능(오타 오류 잡아낼수있음)
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price*discountPercent / 100;
        }else{
            return 0;
        }
    }
}
