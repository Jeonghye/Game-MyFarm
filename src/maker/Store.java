package maker;

public class Store {

	private String[] cropsArr = new String[] {"감자", "고구마", "양파", "마늘", "호박"};
	private int[] seedPrice = new int[] {30, 30, 40, 40, 50};
	private int[] sellPrice = new int[] {100, 100, 130, 130, 200};
	private String[] itemArr = new String[] {"비료", "모종삽", "호미", "낫", "레기"};
	private int[] itemPrice = new int[] {100, 200, 300, 400, 500};


	public String[] getCropsArr() {
		return cropsArr;
	}

	public int[] getSeedPrice() {
		return seedPrice;
	}

	public String[] getItemArr() {
		return itemArr;
	}

	public int[] getItemPrice() {
		return itemPrice;
	}

	public int[] getSellPrice() {
		return sellPrice;
	}
	

}
