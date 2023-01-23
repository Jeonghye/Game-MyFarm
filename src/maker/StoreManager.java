package maker;

import java.util.Scanner;

public class StoreManager {

	Store store = new Store();
	
	Scanner sc = new Scanner(System.in);

	public void storeMenu() {
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
			case 1 : store.buySeed(); break;
			case 2:
				/* store.buyItem(); */ break;
			case 3 : /*수확물 판매*/ break;
			case 9 : 
				System.out.println("메인메뉴로 돌아갑니다."); 
				return;
			default: 
				System.out.println("선택지에 없는 번호입니다. 다시 선택해주세요!"); 
				break;
			}
		}
	}

}
