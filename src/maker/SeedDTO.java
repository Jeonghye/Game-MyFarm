package maker;

public class SeedDTO {
	
	private String name;
	private int count = 0;
	
	public SeedDTO() {}
	
	public SeedDTO(String seedName, int seedCount) {
		this.name = seedName;
		this.count = seedCount;
	}
	
	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}
	
	public String getInformation() {
		return name + "씨앗(" + count + "개)";
	}

}
