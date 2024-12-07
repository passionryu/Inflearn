package hello.core;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.Discount.RateDiscountPolicy;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Member.MemoryMemberRepository;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정 정보
public class Appconfig {

    /* 리펙토링 시  컨트롤 + 알트 + M 을 누르면 된다.*/

    @Bean //스프링 컨테이너에 등록이 된다.
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public static MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
            return new OrderServiceImpl(MemberRepository(), DiscountPolicy());
    }

    @Bean
    private static DiscountPolicy DiscountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
