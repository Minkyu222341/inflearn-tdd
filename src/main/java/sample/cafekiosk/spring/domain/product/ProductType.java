package sample.cafekiosk.spring.domain.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : sample.cafekiosk.spring.domain
 * fileName       : ProductType
 * author         : MinKyu Park
 * date           : 2023-09-20
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-20        MinKyu Park       최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum ProductType {

	HANDMADE("제조 음료"),
	BOTTLE("병 음료"),
	BAKERY("베이커리");

	private final String text;
}
