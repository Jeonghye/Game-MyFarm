
public class SeedInven {
	
	private String seedName;
	private int seedCount = 0;
	
	public SeedInven(String seedName, int seedCount) {
		this.seedName = seedName;
		this.seedCount = seedCount;
	}
	
	public String getInformation() {
		return this.seedName + "/" + this.seedCount + "개";
	}

}
