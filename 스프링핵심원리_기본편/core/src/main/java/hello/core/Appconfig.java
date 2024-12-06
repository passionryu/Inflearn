package hello.core;

import hello.core.Discount.FixDiscountPolicy;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.Member.MemoryMemberRepository;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;

public class Appconfig {

    // 멤버 서비스가 메모리 멤버 레포지토리를 주입받는다.
    // 생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
            return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
