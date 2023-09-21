package sample.cafekiosk.spring.api.controller.order;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sample.cafekiosk.spring.api.service.order.OrderService;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;

/**
 * packageName    : sample.cafekiosk.spring.api.controller.order
 * fileName       : OrderController
 * author         : MinKyu Park
 * date           : 2023-09-21
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-21        MinKyu Park       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/api/v1/orders/new")
	public void createOrder(@RequestBody OrderCreateRequest request) {

		LocalDateTime registeredDateTime = LocalDateTime.now();

		orderService.createOrder(request , registeredDateTime);
	}
}
