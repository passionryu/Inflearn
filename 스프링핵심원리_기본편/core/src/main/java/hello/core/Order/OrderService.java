package hello.core.Order;

public interface OrderService {

    /**
     * 주문 생성 인터페이스
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return 주문 객체
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
