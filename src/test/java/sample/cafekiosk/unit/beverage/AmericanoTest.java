package sample.cafekiosk.unit.beverage;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * packageName    : sample.cafekiosk.unit.beverage
 * fileName       : AmericanoTest
 * author         : MinKyu Park
 * date           : 2023-09-11
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-11        MinKyu Park       최초 생성
 */
class AmericanoTest {

	@Test
	void getName() {
		Americano americano = new Americano();

		// assertEquals(americano.getName(), "아메리카노");
		assertThat(americano.getName()).isEqualTo("아메리카노");
	}

	@Test
	void getPrice() {
		Americano americano = new Americano();

		assertThat(americano.getPrice()).isEqualTo(4000);
	}

}