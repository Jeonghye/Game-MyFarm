package maker;

public class Character {
	
	Wallet wallet = new Wallet();
	InvenManager im = new InvenManager();
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public void payMoney(int price) {
		wallet.payMoney(price);
	}
	
	public void getMoney(int price) {
		wallet.getMoney(price);
	}
	
	public int money() {
		return wallet.money();
	}

	public void showInven() {
		System.out.println("━━━━━━━━━━━━━━━━ 인/벤/토/리 ━━━━━━━━━━━━━━━━");
		im.showItem();
		im.showSeed();
		im.showHarvest();
	}

	public void showWallet() {
		System.out.println("━━━━━━━━━━━━━━━━━━━ 지/갑 ━━━━━━━━━━━━━━━━━━");
		System.out.println(" ▶  지갑 : " + wallet.money() + "G"); 
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
}
