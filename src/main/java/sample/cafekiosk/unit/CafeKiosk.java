package sample.cafekiosk.unit;

import static sample.cafekiosk.unit.Msg.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.order.Order;

/**
 * packageName    : sample.cafekiosk.unit
 * fileName       : CafeKiosk
 * author         : MinKyu Park
 * date           : 2023-09-11
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-11        MinKyu Park       최초 생성
 */
@Getter
public class CafeKiosk {
	private final List<Beverage> beverages = new ArrayList<Beverage>();
	private static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
	private static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);


	public void add(Beverage beverage) {
		beverages.add(beverage);
	}

	public void add(Beverage beverage, int count){
		if (count <= 0) {
			throw new IllegalArgumentException(BEVERAGE_ORDER_SIZE_ERROR.getMessage());
		}

		for (int i = 0; i < count; i++) {
			beverages.add(beverage);
		}
	}

	public void remove(Beverage beverage) {
		beverages.remove(beverage);
	}

	public void clear() {
		beverages.clear();
	}

	public int calculateTotalPrice() {
		return beverages.stream()
			.mapToInt(Beverage::getPrice)
			.sum();
	}

	public Order createOrder() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalTime currentTime = currentDateTime.toLocalTime();

		if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
			throw new IllegalArgumentException(NOT_ORDER_TIME.getMessage());
		}

		return new Order(currentDateTime, beverages);
	}
	public Order createOrder(LocalDateTime currentDateTime) {
		LocalTime currentTime = currentDateTime.toLocalTime();
		System.out.println(currentTime);

		if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
			throw new IllegalArgumentException(NOT_ORDER_TIME.getMessage());
		}

		return new Order(currentDateTime, beverages);
	}


}
