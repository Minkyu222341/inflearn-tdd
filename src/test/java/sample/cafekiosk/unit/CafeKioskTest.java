package sample.cafekiosk.unit;


import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static sample.cafekiosk.unit.Msg.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.beverage.Latte;
import sample.cafekiosk.unit.order.Order;

/**
 * packageName    : sample.cafekiosk.unit
 * fileName       : CafeKioskTest
 * author         : MinKyu Park
 * date           : 2023-09-11
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-11        MinKyu Park       최초 생성
 */
class CafeKioskTest {

	@Test
	void add_manual_test() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());

		System.out.println(">>> 담긴 음료 수 : "+ cafeKiosk.getBeverages().size());
		System.out.println(">>> 담긴 음료: "+ cafeKiosk.getBeverages().get(0).getName());
	}

	@Test
	@DisplayName("한잔 주문 테스트")
	void add() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		cafeKiosk.add(new Americano());

		assertThat(cafeKiosk.getBeverages()).hasSize(1);
		assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
	}

	@Test
	@DisplayName("여러잔 주문 테스트")
	void addSeveralBeverages() throws IllegalAccessException {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();
		Latte latte = new Latte();

		cafeKiosk.add(americano,3);
		assertThat(cafeKiosk.getBeverages()).hasSize(3);
		assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
		assertThat(cafeKiosk.getBeverages().get(1).getName()).isEqualTo("아메리카노");

		cafeKiosk.add(latte,2);
		assertThat(cafeKiosk.getBeverages()).hasSize(5);
		assertThat(cafeKiosk.getBeverages().get(3).getName()).isEqualTo("라테");
		assertThat(cafeKiosk.getBeverages().get(4).getName()).isEqualTo("라테");
	}

	@Test
	@DisplayName("0잔 주문 예외 테스트")
	void addZeroBeverages() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();

		assertThatThrownBy(() -> cafeKiosk.add(americano, 0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(BEVERAGE_ORDER_SIZE_ERROR.getMessage());
	}

	@Test
	@DisplayName("음료 삭제 테스트")
	void remove() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();

		cafeKiosk.add(americano);
		assertThat(cafeKiosk.getBeverages()).hasSize(1);

		cafeKiosk.remove(americano);
		assertThat(cafeKiosk.getBeverages()).isEmpty();
	}

	@Test
	@DisplayName("바구니 전체 삭제 테스트")
	void clear() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();
		Latte latte = new Latte();

		cafeKiosk.add(americano);
		cafeKiosk.add(latte);
		assertThat(cafeKiosk.getBeverages()).hasSize(2);

		cafeKiosk.clear();
		assertThat(cafeKiosk.getBeverages()).isEmpty();
	}

	@Test
	@DisplayName("주문시간 테스트")
	void createOrder() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();
		cafeKiosk.add(americano);

		Order order = cafeKiosk.createOrder();

		assertThat(order.getBeverages()).hasSize(1);
		assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
	}

	@Test
	@DisplayName("주문시간 테스트")
	void creatOrderCurrentTime() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();
		cafeKiosk.add(americano);

		// 매장 오픈 시간
		Order order = cafeKiosk.createOrder(LocalDateTime.of(2023,9,11,10,0));

		assertThat(order.getBeverages()).hasSize(1);
		assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
	}

	@Test
	@DisplayName("주문 시간 예외 테스트")
	void creatOrderOutsideOpenTime() {
		CafeKiosk cafeKiosk = new CafeKiosk();
		Americano americano = new Americano();
		cafeKiosk.add(americano);

		assertThatThrownBy(() -> cafeKiosk.createOrder(LocalDateTime.of(2023, 9, 11, 9, 59)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(NOT_ORDER_TIME.getMessage());
	}
}