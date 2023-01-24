package maker.grow;

import java.util.Scanner;

import maker.FarmManager;

public class GrowManager extends FarmManager {

	private int type = 0; // 선택했던 배열의 작물종류
	private int no = 0; // 선택(가져온)한 배열 행 인덱스
	private int index = 0; //배열 행 인덱스
	public String[][] field = super.getField();
	public String[][] finishField = super.getFinishField();
	private Crops[] crops = new Crops[] {new Potato(), 
			new SweetPotato(),
			new Onion(),
			new Garilc(),
			new Pumpkin()};
	
	Scanner sc = new Scanner(System.in);

	public void setType(int type) {
		this.type = type;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void growStart() {
		growMenu();
	}

	public String[][] getField() {
		return this.field;
	}
	
	public String[][] getFinishField() {
		return this.finishField;
	}

	public void growMenu() {

		while(true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━ /#/ ━━━━━━━━━━━━━━━━━━━");
			System.out.println("선택중인 밭 : " + (no + 1) + ". " + 
					crops[type].getName());
			System.out.println("───────────────────────────────────────────");
			System.out.println("1. 물뿌리기");
			System.out.println("2. 기다리기");
			System.out.println("3. 응원하기");
			System.out.println("9. 나가기");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1 : 
				water();
				isFinish();
				break;
			case 2 : 
				await();
				isFinish();
				break;
			case 3 : 
				cheer();
				isFinish();
				break;
			case 9 : 
				System.out.println("재배를 취소합니다."); 
				return;
			default: 
				System.out.println("선택지에 없는 번호입니다. 다시 선택해주세요!"); 
				break;
			}
		}
	}

	/**
	 * 수확 가능 확인용 메소드
	 * 수확 가능 시 수확가능필드에 넣는다.
	 */
	public void isFinish() {
		
		String[][] temp = new String[10][];

		if(crops[type].finish()) {

			System.out.println("수확이 가능합니다.");
			finishField[index] = field[no];
			field[no] = null;
			index++;

			if(field[no + 1] != null) {
				int value = 0;
				for(int i = 0; i < temp.length; i++) {
					if(field[i] == null) {
						continue;
					} else {
						temp[value] = field[i];
						value++;
					}
				}
				field = temp;
			}
			super.setField(field);
			super.setFinishField(finishField);
			System.out.println("어서 수확해봅시다!");
		}
	}

	/**
	 * 종류별 물을 뿌린다.
	 */
	public void water() {

		if(crops[type] instanceof Potato) {
			((Potato) crops[0]).water();

		} else if(crops[type] instanceof SweetPotato) {
			((SweetPotato) crops[1]).water();

		} else if(crops[type] instanceof Onion) {
			((Onion) crops[2]).water();

		} else if(crops[type] instanceof Garilc) {
			((Garilc) crops[3]).water();

		} else if(crops[type] instanceof Pumpkin) {
			((Pumpkin) crops[4]).water();

		} else {
			System.out.println("오류 발생, 재배할 수 없습니다.");
		}

	}

	/**
	 * 종류별 기다린다.
	 */
	public void await() {

		if(crops[type] instanceof Potato) {
			((Potato) crops[0]).await();

		} else if(crops[type] instanceof SweetPotato) {
			((SweetPotato) crops[1]).await();

		} else if(crops[type] instanceof Onion) {
			((Onion) crops[2]).await();

		} else if(crops[type] instanceof Garilc) {
			((Garilc) crops[3]).await();

		} else if(crops[type] instanceof Pumpkin) {
			((Pumpkin) crops[4]).await();

		} else {
			System.out.println("오류 발생, 재배할 수 없습니다.");
		}

	}

	/**
	 * 종류별 응원한다.
	 */
	public void cheer() {

		if(crops[type] instanceof Potato) {
			((Potato) crops[0]).cheer();

		} else if(crops[type] instanceof SweetPotato) {
			((SweetPotato) crops[1]).cheer();

		} else if(crops[type] instanceof Onion) {
			((Onion) crops[2]).cheer();

		} else if(crops[type] instanceof Garilc) {
			((Garilc) crops[3]).cheer();

		} else if(crops[type] instanceof Pumpkin) {
			((Pumpkin) crops[4]).cheer();

		} else {
			System.out.println("오류 발생, 재배할 수 없습니다.");
		}
	}


}
