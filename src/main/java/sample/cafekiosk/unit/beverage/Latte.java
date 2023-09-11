package sample.cafekiosk.unit.beverage;

import sample.cafekiosk.unit.beverage.Beverage;

/**
 * packageName    : sample.cafekiosk.unit
 * fileName       : Latte
 * author         : MinKyu Park
 * date           : 2023-09-11
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-11        MinKyu Park       최초 생성
 */
public class Latte implements Beverage {

	@Override
	public String getName() {
		return "라테";
	}

	@Override
	public int getPrice() {
		return 4500;
	}
}
