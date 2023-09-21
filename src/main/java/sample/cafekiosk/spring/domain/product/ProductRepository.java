package sample.cafekiosk.spring.domain.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.cafekiosk.spring.domain.product.Product;

/**
 * packageName    : sample.cafekiosk.spring.domain.product.repository
 * fileName       : ProductRepository
 * author         : MinKyu Park
 * date           : 2023-09-20
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-20        MinKyu Park       최초 생성
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingTypes);

	List<Product> findAllByProductNumberIn(List<String> productNumbers);
}
