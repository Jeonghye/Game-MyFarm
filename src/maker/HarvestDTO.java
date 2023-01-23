package maker;

public class HarvestDTO {
	
	private String harvestName;
	private int harvestCount = 0;
	
	public HarvestDTO() {}
	
	public HarvestDTO(String harvestName, int harvestCount) {
		this.harvestName = harvestName;
		this.harvestCount = harvestCount;
	}

	public String getInformation() {
		return harvestName + "/" + harvestCount + "개";
	}

}
