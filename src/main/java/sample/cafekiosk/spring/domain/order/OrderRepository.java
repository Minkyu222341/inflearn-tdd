package sample.cafekiosk.spring.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : sample.cafekiosk.spring.domain.order
 * fileName       : OrderRepository
 * author         : MinKyu Park
 * date           : 2023-09-21
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-21        MinKyu Park       최초 생성
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
