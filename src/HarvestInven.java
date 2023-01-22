
public class HarvestInven {
	
	private String harvestName;
	private int harvestCount = 0;
	
	public HarvestInven(String harvestName, int harvestCount) {
		this.harvestName = harvestName;
		this.harvestCount = harvestCount;
	}

	public String getInformation() {
		return harvestName + "/" + harvestCount + "개";
	}

}
