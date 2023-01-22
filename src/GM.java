import java.util.Scanner;

public class GM {

	Character character = new Character();
	Wallet wallet = new Wallet();
	Inventory inventory = new Inventory();

	Scanner sc = new Scanner(System.in);
	
	public GM() {
		System.out.println("(∩^o^)⊃━☆ ** My Farm에 오신걸 환영합니다~! **");
	}
	
	public void startGame() {
//		setYourName();			//캐릭터 이름 설정
		mainMenu();				//메인메뉴화면
	}

	public void setYourName() {
		System.out.println("━━━━━━━━━━ 캐릭터 이름을 정해주세요. ━━━━━━━━━━");
		System.out.print("★ 캐릭터 이름 : ");
		String name = sc.nextLine();
		System.out.println();
		System.out.println("캐릭터 이름은 【 " + name + " 】입니다!");
		character.setName(name);
	}

	public void mainMenu() {

		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━ 메/인/메/뉴 ━━━━━━━━━━━━━━━━");
			System.out.println("1. 인벤토리 확인");
			System.out.println("2. 지갑 확인");
			System.out.println("3. 밭 확인");
			System.out.println("4. 상점 가기");
			System.out.println("9. 게임 종료");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1: showInven(); break;
			case 2: showWallet(); break;
			case 3: showFarm(); break;
			case 4: goStore(); break;
			case 9: System.out.println("게임을 종료합니다."); return;
			default: System.out.println("선택지가 없는 번호입니다. 다시 선택해주세요!"); break;
			}
		}
	}
	
	public void showInven() {
		System.out.println("━━━━━━━━━━━━━━━━ 인/벤/토/리 ━━━━━━━━━━━━━━━━");
		inventory.showItem();
		inventory.showSeed();
		inventory.showHarvest();
	}
	
	public void showWallet() {
		System.out.println("━━━━━━━━━━━━━━━━━━━ 지/갑 ━━━━━━━━━━━━━━━━━━");
		System.out.println(" ▶ " + wallet.showMoney()); 
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public void showFarm() {
		System.out.println("━━━━━━━━━━━━━━━━━━━ /#/ ━━━━━━━━━━━━━━━━━━━");
		
	}
	
	public void goStore() {
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
