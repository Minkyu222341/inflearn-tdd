package sample.cafekiosk.spring.domain.product;

import static org.assertj.core.api.Assertions.*;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.*;
import static sample.cafekiosk.spring.domain.product.ProductType.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * packageName    : sample.cafekiosk.spring.domain.product
 * fileName       : ProductRepositoryTest
 * author         : MinKyu Park
 * date           : 2023-09-20
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-20        MinKyu Park       최초 생성
 */
@ActiveProfiles("test")
// @SpringBootTest
@DataJpaTest
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;


	@Test
	@DisplayName("원하는 판매상태를 가진 상품들을 조회한다.")
	void findAllBySellingStatusIn() {
	    // given
		Product product1 = Product.builder()
			.productNumber("001")
			.type(HANDMADE)
			.name("아메리카노")
			.sellingStatus(SELLING)
			.price(4000)
			.build();

		Product product2 = Product.builder()
			.productNumber("002")
			.type(HANDMADE)
			.name("카페라테")
			.sellingStatus(HOLD)
			.price(4500)
			.build();

		Product product3 = Product.builder()
			.productNumber("003")
			.type(HANDMADE)
			.name("팥빙수")
			.sellingStatus(STOP_SELLING)
			.price(7500)
			.build();

		productRepository.saveAll(List.of(product1, product2, product3));

	    // when
		List<Product> products = productRepository.findAllBySellingStatusIn(List.of(SELLING, HOLD));

		// then
		assertThat(products).hasSize(2)
			.extracting("productNumber", "name", "sellingStatus") // 조회하려는 컬럼들의 이름
			.containsExactlyInAnyOrder( // 해당 데이터들이 존재하는지 - 순서 상관 x
				tuple("001","아메리카노",SELLING),
				tuple("002","카페라테",HOLD)
			);
	}

}