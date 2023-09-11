package sample.cafekiosk.unit;

import lombok.Getter;

/**
 * packageName    : sample.cafekiosk.unit
 * fileName       : Msg
 * author         : MinKyu Park
 * date           : 2023-09-11
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-11        MinKyu Park       최초 생성
 */
@Getter
public enum Msg {
	BEVERAGE_ORDER_SIZE_ERROR("음료는 1잔이상 주문 하실 수 있습니다."),
	NOT_ORDER_TIME("주문 시간이 아닙니다.");

	private final String message;

	Msg(String message) {
		this.message = message;
	}
}
