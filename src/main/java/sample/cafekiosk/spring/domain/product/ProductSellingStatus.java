package sample.cafekiosk.spring.domain.product;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : sample.cafekiosk.spring.domain
 * fileName       : ProductSellingType
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
public enum ProductSellingStatus {

	SELLING("판매중"),
	HOLD("판매보류"),
	STOP_SELLING("판매중지");


	private final String text;

	public static List<ProductSellingStatus> forDisplay() {
		return List.of(SELLING,HOLD);
	}
}
