package maker;

public class Inventory {
	
	private String[] items = new String[] {"괭이", "물뿌리개","","","","",""};
	private SeedDTO[] seeds = new SeedDTO[10];
	private HarvestDTO[] harvests = new HarvestDTO[10];
	
	public String[] getItems() {
		return items;
	}

	public SeedDTO[] getSeeds() {
		return seeds;
	}

	public HarvestDTO[] getHarvests() {
		return harvests;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public void setSeeds(SeedDTO[] seeds) {
		this.seeds = seeds;
	}

	public void setHarvests(HarvestDTO[] harvests) {
		this.harvests = harvests;
	}

}
