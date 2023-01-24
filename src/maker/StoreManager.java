package maker;

import java.util.Scanner;

public class StoreManager extends Store {

	private String[] cropsArr = super.getCropsArr();
	private int[] seedPrice = super.getSeedPrice();
	private int[] sellPrice = super.getSellPrice();
	private String[] itemArr = super.getItemArr();
	private int[] itemPrice = super.getItemPrice();

	Scanner sc = new Scanner(System.in);

	public void storeMenu(Character character, InvenManager im) {

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("상점주인 : 어서오시게~ 팜상점에 온 걸 환영한다네~ ");

		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━ 상/점/메/뉴 ━━━━━━━━━━━━━━━━");
			System.out.println("1. 씨앗 구매");
			System.out.println("2. 아이템 구매");
			System.out.println("3. 수확물 판매");
			System.out.println("9. 나가기");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1 : buySeed(character, im); break;
			case 2 : buyItem(character, im); break;
			case 3 : sellHarvest(character, im); break;
			case 9 : 
				System.out.println("메인메뉴로 돌아갑니다."); 
				return;
			default: 
				System.out.println("선택지에 없는 번호입니다. 다시 선택해주세요!"); 
				break;
			}
		}
	}

	public void seedList() {
		System.out.println("━━━━━━━━━━━━━━━━ 씨/앗/목/록 ━━━━━━━━━━━━━━━━");
		for (int i = 0; i < cropsArr.length; i++) {
			System.out.print((i + 1) + ". " + cropsArr[i] + "(" +seedPrice[i] + "G) ");
		}
		System.out.println();
	}

	public void itemList() {
		System.out.println("━━━━━━━━━━━━━━━ 아/이/템/목/록 ━━━━━━━━━━━━━━━");
		for (int i = 0; i < itemArr.length; i++) {
			System.out.print((i + 1) + ". " + itemArr[i] + "(" +itemPrice[i] + "G) ");
		}
		System.out.println();
	}

	/* 씨앗 구매 메소드 */
	public void buySeed(Character character, InvenManager im) {

		seedList();

		System.out.println("구매할 씨앗의 번호를 입력하세요 (취소 : 0): ");
		int no = sc.nextInt();

		if (no == 0) {
			System.out.println("씨앗 구매를 취소합니다.");
			return;
		}

		if(no <= cropsArr.length) {
			System.out.println("구매하실 " + cropsArr[no - 1] + "씨앗의 수량을 적어주세요 : ");
			int count = sc.nextInt();

			int price = seedPrice[no - 1] * count;
			System.out.println("총합 " + price + "G 입니다.");

			if(isPay(character.money(), price)) {
				System.out.println("결제완료되셨습니다. 구매해주셔서 감사합니다.");
				im.insertSeed(cropsArr[no - 1], count);
				character.payMoney(price);
				System.out.println("현재 소지 골드는 " + character.money() + "G 입니다.");
				return;
			} else {
				System.out.println("골드가 부족합니다. 현재 소지 골드는 " + character.money() + "G 입니다.");
			}
		} else {
			System.out.println("상점주인 : 대체 뭘 사겠다는 건가? 제대로 고르시게");
		}
	}

	/* 아이템 구매 메소드 */
	public void buyItem(Character character, InvenManager im) {

		itemList();

		System.out.print("구매할 아이템 번호를 입력하세요 (취소 : 0): ");
		int no = sc.nextInt();

		if(no == 0) {
			System.out.println("아이템 구매를 취소합니다.");
			return;
		}

		if(no <= itemArr.length) {
			int price = itemPrice[no - 1];
			System.out.println(price + "G 입니다.");

			if(isPay(character.money(), price)) {
				System.out.println("결제완료되셨습니다. 구매해주셔서 감사합니다.");
				im.insertItem(itemArr[no - 1]);
				character.payMoney(price);
				System.out.println("현재 소지 골드는 " + character.money() + "G 입니다.");
				return;
			} else {
				System.out.println("골드가 부족합니다. 현재 소지 골드는 " + character.money() + "G 입니다.");
			}
		} else {
			System.out.println("상점주인 : 대체 뭘 사겠다는 건가? 제대로 고르시게");
		}
	}

	/* 지불 가능한지 확인용 메소드 */
	public boolean isPay(int wallet, int payMoney) {
		boolean result = false;
		if(wallet >= payMoney) {
			result = true;
		}

		return result;
	}

	/* 수확물 판매 메소드 */
	public void sellHarvest(Character character, InvenManager im) {

		HarvestDTO[] harvests = im.getHarvests();

		System.out.println("상점주인 : 드디어 수확을 했나보군! 무엇을 판매할건가?");
		System.out.println("━━━━━━━━━━━━━━━━ 판/매/가/능 ━━━━━━━━━━━━━━━━");
		im.showHarvest();
		System.out.print("판매할 수확물의 번호 입력 (취소 : 0): ");
		int no = sc.nextInt();
		
		int num = no - 1;
		int price = 0;

		if(no == 0) {
			System.out.println("판매를 취소합니다.");
			return;
		}
		
		if(harvests[0] == null) {
			System.out.println("상점주인 : 우리 상점은 공기는 취급 안하네");
		} else if(harvests[num] == null) {
			System.out.println("상점주인 : 저런, 팔 수 있는 게 없군!");
			return;
		} else {
			System.out.println(harvests[num].getInformation() + "를 판매합니다.");
			for (int i = 0; i < cropsArr.length; i++) {
				if(harvests[num].getName().equals(cropsArr[i])) {
					price = harvests[num].getCount() * sellPrice[num];
					break;
				}
			}
			System.out.println("총합 " + price + "G 입니다.");
			character.getMoney(price);
		}
	}












}