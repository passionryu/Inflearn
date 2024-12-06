package hello.core.Order;

import hello.core.Appconfig;
import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    // 각 테스트 이전에 다음을 실행
    @BeforeEach
    public void beforeEach(){
        Appconfig appconfig  = new Appconfig();
        memberService = appconfig.memberService();
        orderService = appconfig.orderService();
    }

    /* 아래 코드들은 DIP를 지키지 못하는 코드들임 */
    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
