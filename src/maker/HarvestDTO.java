package maker;

public class HarvestDTO {
	
	private String name;
	private int count = 0;
	
	public HarvestDTO() {}
	
	public HarvestDTO(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}
	
	public String getInformation() {
		return name + "(" + count + "개)";
	}

}
