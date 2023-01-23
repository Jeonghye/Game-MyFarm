package maker;

import java.util.Scanner;

public class Farm {
	
	InvenManager im = new InvenManager();
	
	private String[][] field;
	private int index = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public void reclaim() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("괭이를 이용하여 밭을 개간하자!");
		System.out.println("몇 타일을 개간하시겠습니까? (씨앗 1개 == 타일 1개)");
		System.out.print("입력 : ");
		int count = sc.nextInt();
		
		field = new String[index][count];
		index++;
		System.out.println("현재 " + count + "타일이 씨앗 심을 준비가 끝났습니다!");
	}
	
	public void plant() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("인벤토리에 있는 씨앗을 심어보자!");
		im.showSeed();
		
	}
	
	public void grow() {}
	
	public void harvest() {}
	
}
