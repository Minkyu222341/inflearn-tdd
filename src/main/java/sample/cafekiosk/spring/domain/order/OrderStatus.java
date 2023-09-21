package sample.cafekiosk.spring.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : sample.cafekiosk.spring.domain.order
 * fileName       : OrderStatus
 * author         : MinKyu Park
 * date           : 2023-09-21
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-21        MinKyu Park       최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum OrderStatus {

	INIT("주문생성"),
	CANCELED("주문취소"),
	PAYMENT_COMPLETED("결제완료"),
	PAYMENT_FAILED("결제실패"),
	RECEIVED("주문접수"),
	COMPLETED("처리완료");

	private final String text;

}
