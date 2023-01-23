package maker;

import java.util.Scanner;

public class Store {

	Character you = new Character();
	Wallet w = new Wallet();
	InvenManager im = new InvenManager();

	String[] seedArr = new String[] {"감자씨앗", "고구마씨앗", "양파씨앗", "마늘씨앗", "호박씨앗"};
	int[] seedPrice = new int[] {30, 30, 40, 40, 50};
	String[] itemArr = new String[] {"비료", "모종삽", "호미", "낫", "레기"};
	int[] itemPrice = new int[] {100, 200, 300, 400, 500};

	Scanner sc = new Scanner(System.in);

	public String[] getSeedArr() {
		return seedArr;
	}

	public int[] getSeedPrice() {
		return seedPrice;
	}

	public String[] getItemArr() {
		return itemArr;
	}

	public int[] getItemPrice() {
		return itemPrice;
	}

	public void seedList() {
		System.out.println("━━━━━━━━━━━━━━━━ 씨/앗/목/록 ━━━━━━━━━━━━━━━━");
		for (int i = 0; i < seedArr.length; i++) {
			System.out.print((i + 1) + ". " + seedArr[i] + "/" +seedPrice[i] + "G  ");
		}
		System.out.println();
	}

	public void buySeed() {

		seedList();

		System.out.println("무엇을 주문하시겠습니까? (번호):");
		int no = sc.nextInt();

		if((no - 1) < seedArr.length) {
			System.out.println("구매하실 " + seedArr[no - 1] + "의 수량을 적어주세요 : ");
			int count = sc.nextInt();
			
			int price = seedPrice[no - 1] * count;
			System.out.println("총합 " + price + "G 입니다.");

			if(isPay(w.money(), price)) {
				System.out.println("결제완료되셨습니다. 구매해주셔서 감사합니다.");
				im.insertSeed(seedArr[no - 1], count);
				im.showSeed();
				w.payMoney(price);
				System.out.println("현재 소지 골드는 " + w.money() + "입니다.");
				return;
			} else {
				System.out.println("골드가 부족합니다. 현재 소지 골드는 " + w.money() + "입니다.");
			}
			
		} else {
			System.out.println("판매하지 않는 번호 입니다. 다시 입력해주세요.");
		}

	}

	public boolean isPay(int wallet, int payMoney) {
		boolean result = false;
		if(wallet >= payMoney) {
			result = true;
		}

		return result;
	}

	public void save() {

	}

}
