package sample.cafekiosk.unit.beverage;

/**
 * packageName    : sample.cafekiosk.unit
 * fileName       : Americano
 * author         : MinKyu Park
 * date           : 2023-09-11
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-11        MinKyu Park       최초 생성
 */
public class Americano implements Beverage{
	@Override
	public String getName() {
		return "아메리카노";
	}

	@Override
	public int getPrice() {
		return 4000;
	}
}
