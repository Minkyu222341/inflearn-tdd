package sample.cafekiosk.spring.api.controller.order.request;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : sample.cafekiosk.spring.api.service.order.request
 * fileName       : OrderCreateRequest
 * author         : MinKyu Park
 * date           : 2023-09-21
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-21        MinKyu Park       최초 생성
 */
@Getter
public class OrderCreateRequest {

	private List<String> productNumbers;

	@Builder
	private OrderCreateRequest(List<String> productNumbers) {
		this.productNumbers = productNumbers;
	}
}
