package sample.cafekiosk.unit.order;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sample.cafekiosk.unit.beverage.Beverage;

/**
 * packageName    : sample.cafekiosk.unit.order
 * fileName       : Order
 * author         : MinKyu Park
 * date           : 2023-09-11
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-11        MinKyu Park       최초 생성
 */
@Getter
@RequiredArgsConstructor
public class Order {

	private final LocalDateTime orderDateTime;

	private final List<Beverage> beverages;
}
