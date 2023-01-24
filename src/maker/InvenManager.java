package maker;

public class InvenManager {

	Inventory inven = new Inventory();

	public String[] items = inven.getItems();
	public SeedDTO[] seeds = inven.getSeeds();
	public HarvestDTO[] harvests = inven.getHarvests();

	/**
	 * 아이템 획득 시 인벤토리에 저장
	 */
	public void insertItem(String name) {

		for(int i = 0; i < items.length; i++) {
			if(items[i] == "") {
				items[i] = name;
				break;
			}
		}

		inven.setItems(items);
	}

	/**
	 * 아이템 지우기
	 */
	public void deleteItem(String name) {

		for (int i = 0; i < items.length; i++) {
			for (int j = 1; j < i; j++) {
				if(name == items[i]) {
					String temp;
					temp = items[i];
					items[i] = items[j];
				}
			}
		}
	}

	/**
	 * 소유한 아이템 목록 보기
	 */
	public void showItem() {

		System.out.print("《아이템》 : ");

		for(int i = 0; i < items.length; i++) {
			if(items[i] != "") {
				System.out.print((i + 1) + ". " + items[i] + " ");
			}
		}

		System.out.println();
	}

	/**
	 * 씨앗 획득 시 인벤토리에 저장
	 */
	public void insertSeed(String name, int count) {

		for(int i = 0; i < seeds.length; i++) {
			if(seeds[i] == null) {
				seeds[i] = new SeedDTO(name, count);
				break;
			}
		}

		inven.setSeeds(seeds);
	}

	/**
	 * 인벤토리에서 씨앗 삭제
	 */
	public void removeSeed(int no) {
		
		int index = no - 1;
		
		SeedDTO[] temp = new SeedDTO[1];
		temp[0] = seeds[index];
		seeds[index] = null;
		
		if(seeds[index + 1] != null) {
			for(int i = 0; i < seeds.length; i++) {
				if((index + i) < seeds.length) {
					seeds[index] = seeds[index + i];
					seeds[index + i] = seeds[index + i + 1];
					break;
				} else {
					seeds[index + i] = null;
				}
			}
		}

		inven.setSeeds(seeds);
	}


	/**
	 * 소유한 씨앗 목록 보기
	 */
	public void showSeed() {

		System.out.print("《씨앗》 : ");

		for(int i = 0; i < seeds.length; i++) {
			if(seeds[0] == null) {
				System.out.print(" ");
				break;
			} else if(seeds[i] != null){
				System.out.print((i + 1) + ". " + seeds[i].getInformation() + " ");
			}
		}

		System.out.println();
	}

	/**
	 * 수확물 획득 시 인벤토리에 저장
	 */
	public void insertHarvest(String[][] arr, int no) {

		String name = arr[no][0];
		int count = arr[no].length;
		
		for(int i = 0; i < harvests.length; i++) {
			if(harvests[i] == null) {
				harvests[i] = new HarvestDTO(name, count);
				break;
			}
		}

		inven.setHarvests(harvests);
	}

	/**
	 * 인벤토리에서 수확물 삭제
	 */
	public void removeHarvest(HarvestDTO[] arr, int index) {

		if(arr[index] == null) {
			arr[index - 1] = null;
		}

		HarvestDTO[] temp = new HarvestDTO[1];

		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[index - 1] == arr[i]) {
					temp[0] = arr[i];
					arr[i] = arr[j];
					arr[j] = new HarvestDTO();
					break;
				}
			}
		}

		inven.setHarvests(arr);
	}

	/**
	 * 소유한 수확물 목록 보기
	 */
	public void showHarvest() {

		System.out.print("《수확물》 : ");

		for(int i = 0; i < harvests.length; i++) {
			if(harvests[0] == null) {
				System.out.print(" ");
				break;
			} else if(harvests[i] != null){
				System.out.print((i + 1) + ". " + harvests[i].getInformation() + " ");
			}
		}

		System.out.println();
	}
}
