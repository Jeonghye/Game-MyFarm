package maker;

import java.util.Scanner;

import maker.grow.GrowManager;

public class GameManager {

	Character character = new Character();
	StoreManager sm = new StoreManager();
	FarmManager fm = new FarmManager();
	GrowManager growM = new GrowManager();
	InvenManager im = new InvenManager();
	
	Scanner sc = new Scanner(System.in);

	public GameManager() {
		System.out.println("(∩^o^)⊃━☆ ** My Farm에 오신걸 환영합니다~! **");
	}

	public void startGame() {
//		setYourName();
		mainMenu();
	}

	public void setYourName() {
		System.out.println("━━━━━━━━━━━━ 캐릭터 이름을 정해주세요. ━━━━━━━━━━━");
		System.out.print("★ 캐릭터 이름 : ");
		String name = sc.nextLine();
		System.out.println();
		System.out.println("캐릭터 이름은 【 " + name + " 】입니다!");
		character.setName(name);
	}

	public void mainMenu() {
		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━ 메/인/메/뉴 ━━━━━━━━━━━━━━━━━");
			System.out.println("1. 인벤토리 확인");
			System.out.println("2. 지갑 확인");
			System.out.println("3. 밭 확인");
			System.out.println("4. 상점 가기");
			System.out.println("9. 게임 종료");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1: 
				character.showInven(im); 
				break;
			case 2:
				character.showWallet(); 
				break;
			case 3: 
				fm.farmMenu(im, growM);
				break;
			case 4: 
				sm.storeMenu(character, im); 
				break;
			case 9: 
				System.out.println("게임을 종료합니다."); 
				return;
			default: 
				System.out.println("선택지에 없는 번호입니다. 다시 선택해주세요!"); 
				break;
			}
		}
	}
	








}
