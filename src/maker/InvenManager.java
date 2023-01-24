package maker;

public class InvenManager extends Inventory {

	private String[] items = super.getItems();
	private SeedDTO[] seeds = super.getSeeds();
	private HarvestDTO[] harvests = super.getHarvests();

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

		super.setItems(items);
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

		super.setSeeds(seeds);
	}

	/**
	 * 인벤토리에서 씨앗 삭제
	 */
	public void removeSeed(int no) {

		int index = no - 1;

		SeedDTO[] temp = new SeedDTO[10];
		seeds[index] = null;

		if(seeds[index + 1] != null) {
			int value = 0;
			for(int i = 0; i < temp.length; i++) {
				if(seeds[i] == null) {
					continue;
				} else {
					temp[value] = seeds[i];
					value++;
				}
			}
			seeds = temp;
		}

		super.setSeeds(seeds);
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
	public void insertHarvest(String[][] arr, int no, int count) {

		String name = arr[no - 1][0];
		
		for(int i = 0; i < harvests.length; i++) {
			if(harvests[i] == null) {
				harvests[i] = new HarvestDTO(name, count);
				break;
			}
		}

		super.setHarvests(harvests);
	}

	/**
	 * 인벤토리에서 수확물 삭제
	 */
	public void removeHarvest(int no) {

		int index = no - 1;

		HarvestDTO[] temp = new HarvestDTO[10];
		harvests[index] = null;

		if(harvests[index + 1] != null) {
			int value = 0;
			for(int i = 0; i < temp.length; i++) {
				if(harvests[i] == null) {
					continue;
				} else {
					temp[value] = harvests[i];
					value++;
				}
			}
			harvests = temp;
		}

		super.setHarvests(harvests);
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
