package maker;

import java.util.Scanner;

import maker.grow.GrowManager;

public class FarmManager extends Farm {

	public String[][] field = super.getField();
	public String[][] finishField = super.getFinishField();
	private int index = 0; // field 인덱스

	Scanner sc = new Scanner(System.in);

	public void farmMenu(InvenManager im, GrowManager growM) {

		setField(growM.getField());
		setFinishField(growM.getFinishField());

		while(true) {
			present();
			System.out.println("━━━━━━━━━━━━━━━━━━━ /#/ ━━━━━━━━━━━━━━━━━━━");
			System.out.println("1. 개간하기");
			System.out.println("2. 씨앗심기");
			System.out.println("3. 재배하기");
			System.out.println("4. 수확하기");
			System.out.println("9. 나가기");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1 : 
				reclaim(im); 
				break;
			case 2 : 
				plant(im); 
				break;
			case 3 : 
				grow(growM);
				break;
			case 4 : 
				harvest(im); 
				break;
			case 9 : 
				System.out.println("메인메뉴로 돌아갑니다."); 
				return;
			default: 
				System.out.println("선택지에 없는 번호입니다. 다시 선택해주세요!"); 
				break;
			}
		}
	}

	/**
	 * 현재 재배중인 밭 보기
	 */
	public void present() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("현재 재배중인 밭...");

		if(field[0] == null && finishField[0] == null) {
			System.out.println("...                           ...");
			System.out.println("      휑~... 아무것도 없습니다.");
			System.out.println("...                           ...");
		}
		showField();
		showFinishField();
	}

	/**
	 * 밭 목록
	 */
	public void showField() {
		for(int i = 0; i < field.length; i++) {
			if(field[i] == null) {
				continue;
			} else	if(field[i][0] == null) {
				System.out.println((i + 1) + "번째 밭 - 개간완료");
				continue;
			} else {
				System.out.println((i + 1) + "번째 밭 - " + field[i][0]);
			}

		}
	}

	public void showFinishField() {
		for(int i = 0; i < finishField.length; i++) {
			if(finishField[i] != null) {
				if(finishField[i][0] != null) {
					System.out.println((i + 1) + "번째 밭 - " +
							finishField[i][0] + "(수확가능)");
				}
			}
		}
	}

	/**
	 * 밭 개간하기 메소드 
	 */
	public void reclaim(InvenManager im) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("괭이를 이용하여 밭을 개간하자!");
		System.out.println("주의 : 씨앗의 종류별로 개간하실 수 있습니다.");
		System.out.println("───────────────────────────────────────────");
		im.showSeed(); //인벤토리 씨앗 목록
		System.out.println("───────────────────────────────────────────");
		System.out.println("몇 타일을 개간하시겠습니까? (씨앗 1개 == 타일 1개)");
		System.out.print("개간할 타일 수 입력 (취소 : 0) : ");
		int count = sc.nextInt();

		if(count == 0) {
			System.out.println("개간을 취소합니다.");
			return;
		}
		field[index] = new String[count];
		super.setField(field);

		System.out.println("현재 " + count + "타일이 씨앗 심을 준비가 끝났습니다!");
	}

	/**
	 * 씨앗 심기 메소드
	 */
	public void plant(InvenManager im) {

		SeedDTO[] seeds = im.getSeeds();

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("인벤토리에 있는 씨앗을 심어보자!");
		System.out.println("───────────────────────────────────────────");
		im.showSeed(); //인벤토리 씨앗 목록
		System.out.println("───────────────────────────────────────────");
		System.out.print("심고자 할 작물의 번호 입력 (취소 : 0): ");
		int no = sc.nextInt();

		if(no == 0) {
			System.out.println("심기를 취소합니다.");
			return;
		}

		int num = no - 1;

		if(field[index] == null) {
			System.out.println("아무 타일도 개간되어 있지 않습니다. 개간부터 해주세요.");

			return;
		} else if(seeds[num] == null) {
			System.out.println("심을 수 있는 씨앗이 없습니다.");

			return;
		}

		if(seeds[num].getCount() <= field[index].length) {
			System.out.println(seeds[num].getName() + " " + 
					seeds[num].getCount() + "개를 심어봅시다!");

			for (int i = 0; i < seeds[num].getCount(); i++) {
				field[index][i] = seeds[num].getName();
				System.out.println(seeds[num].getName() + 
						"을/를 심었다! +" + (i + 1) + "타일");
			}

			index++;
			im.removeSeed(no);
		} else {
			System.out.println("심을 수 있는 타일이 부족해요! "
					+ "씨앗 갯수만큼 개간 후 심어주세요.");
		}
	}

	/**
	 * 재배하기 및 재배하기매니저 메뉴호출
	 */
	public void grow(GrowManager growM) {

		setField(growM.getField());
		setFinishField(growM.getFinishField());

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("심은 농작물을 재배해보자!");
		System.out.println("───────────────────────────────────────────");
		showField();
		System.out.println("───────────────────────────────────────────");
		System.out.print("재배할 밭 번호 입력 (취소 : 0) : ");
		int no = sc.nextInt();

		if(no == 0) {
			System.out.println("재배를 취소합니다.");
			return;
		}

		if(divide(no) == 5) {
			return;
		} else {
			System.out.println(no + "번째 밭." + field[no - 1][0] + "을/를 선택하셨습니다.");
			growM.setNo(no - 1);
			growM.setType(divide(no));
			growM.growStart();
		}

	}

	/**
	 * 선택한 번호에 따라 농작물 구분하는 메소드
	 * @param 재배할 밭의 번호
	 * @return 감자 0, 고구마 1, 양파 2, 마늘 3, 호박 4, null 5
	 */
	public int divide(int no) {

		if(field[no - 1] == null) {
			System.out.println("재배할 수 있는 밭이 없습니다.");
		} else {
			switch(field[no - 1][0].charAt(0)) {
				case '감' : return 0;
				case '고' : return 1;
				case '양' : return 2;
				case '마' : return 3;
				case '호' : return 4;
			}
		}
		return 5;
	}

	public void harvest(InvenManager im) {

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("수확 가능 목록");
		showFinishField();
		System.out.println("───────────────────────────────────────────");
		System.out.print("수확할 밭 번호 입력 (취소 : 0) : ");
		int no = sc.nextInt();

		if(no == 0) {
			return;
		} else {
			
			int count = 0;
			for (int i = 0; i < finishField[no - 1].length; i++) {
				if(finishField[no - 1][i] == null) {
					continue;
				}
				count++;
			}
			System.out.println(finishField[no - 1][0] + "을 총 " + 
					count + "개 수확했습니다.");
			im.insertHarvest(finishField, no, count);
			finishField[no - 1] = null;
		}
	}

	public String[][] getField() {
		return field;
	}

	public String[][] getFinishField() {
		return finishField;
	}

	public void setField(String[][] field) {
		this.field = field;
	}

	public void setFinishField(String[][] finishField) {
		this.finishField = finishField;
	}


}
