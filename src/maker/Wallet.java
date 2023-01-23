package maker;

public class Wallet {
	
	private int money = 500;
	
	/**
	 * 
	 * @return 현재 지갑 잔액
	 */
	
	public void payMoney(int price) {
		int minus = this.money - price;
		this.money = minus;
	}

	public void getMoney(int price) {
		int plus = this.money + price;
		this.money = plus;
	}
	
	public int money() {
		return money;
	}
	
	

}
