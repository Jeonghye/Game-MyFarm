package maker;

import java.util.Scanner;

public class FarmManager {

	Farm farm = new Farm();
	
	Scanner sc = new Scanner(System.in);

	public void farmMenu() {
		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━ /#/ ━━━━━━━━━━━━━━━━━━━");
			System.out.println("1. 개간하기");
			System.out.println("2. 씨앗심기");
			System.out.println("3. 재배하기");
			System.out.println("4. 수확하기");
			System.out.println("9. 나가기");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1 : farm.reclaim(); break;
			case 2 : farm.plant(); break;
			case 3 : /*재배하기*/ break;
			case 4 : /*수확하기*/ break;
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
