
public class Inventory {

	private String[] items = new String[] {"괭이", "물뿌리개","","","","",""};
	private SeedInven[] seeds = new SeedInven[10];
	private HarvestInven[] harvests = new HarvestInven[10];

	/**
	 * 소유한 아이템 목록 보기
	 */
	public void showItem() {
		System.out.println("《아이템》");
		for(int i = 0; i < items.length; i++) {
			if(items[i] != "") {
				System.out.print((i + 1) + "." + items[i] + " ");
			}
		}
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	/**
	 * 아이템 획득 시 아이템 인벤토리에 넣기
	 */
	public void getItem(String itemName) {
		for(int i = 0; i < items.length; i++) {
			if(items[i] == "") {
				items[i] = itemName;
				break;
			}
		}
	}

	/**
	 * 단일 씨앗 얻음
	 */
	public void getSeed(String name, int count) {
		for(int i = 0; i < seeds.length; i++) {
			if(seeds[i] == null) {
				seeds[i] = new SeedInven(name, count);
				break;
			}
		}
	}

	/**
	 * 소유한 씨앗 목록 보기
	 */
	public void showSeed() {
		System.out.println("《씨앗》");
		for(int i = 0; i < seeds.length; i++) {
			if(seeds[0] == null) {
				System.out.print("휑~");
				break;
			} else if(seeds[i] != null){
				System.out.print((i + 1) + "." + seeds[i].getInformation() + " ");
			}
		}
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}

	/**
	 * 수확물 얻으면 인벤토리에 넣기
	 */
	public void getHarvest(String name, int count) {
		for(int i = 0; i < harvests.length; i++) {
			if(harvests[i] == null) {
				harvests[i] = new HarvestInven(name, count);
				break;
			}
		}
	}
	

	/**
	 * 소유한 수확물 목록 보기
	 */
	public void showHarvest() {
		System.out.println("《수확물》");
		for(int i = 0; i < harvests.length; i++) {
			if(harvests[0] == null) {
				System.out.print("휑~");
				break;
			} else if(harvests[i] != null){
				System.out.print((i + 1) + "." + harvests[i].getInformation() + " ");
			}
		}
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}


}
