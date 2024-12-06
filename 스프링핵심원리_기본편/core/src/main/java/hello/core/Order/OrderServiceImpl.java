package hello.core.Order;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberREpository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**
     * 주문 생성 서비스
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return 주문 객체
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberREpository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName,itemPrice,discountPrice);
    }
}
