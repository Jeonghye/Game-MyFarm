
public class Wallet {
	
	private int money = 500;
	
	/**
	 * 
	 * @return 현재 지갑 잔액
	 */
	public String showMoney() {
		return "지갑 : " + this.money + "G";
	}

	/**
	 * 
	 * @param 지출
	 * @return 내야할 돈
	 */
	public int giveMoney(int money) {
		this.money -= money;
		return money;
	}

	/**
	 * 
	 * @param 수입
	 */
	public void getMoney(int money) {
		this.money += money;
	}
	
	

}
