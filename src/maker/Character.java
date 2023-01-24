package maker;

public class Character {
	
	Wallet wallet = new Wallet();
	
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

	public void showInven(InvenManager im) {
		System.out.println("━━━━━━━━━━━━━━━━ 인/벤/토/리 ━━━━━━━━━━━━━━━━");
		System.out.println(" ▶  " + name + "의 현재 가지고 있는 목록들");
		System.out.println();
		
		im.showItem();
		System.out.println();
		im.showSeed();
		System.out.println();
		im.showHarvest();
	}

	public void showWallet() {
		System.out.println("━━━━━━━━━━━━━━━━━━━ 지/갑 ━━━━━━━━━━━━━━━━━━");
		System.out.println(" ▶  "+ name + "의 지갑 : " + wallet.money() + "G"); 
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
}
