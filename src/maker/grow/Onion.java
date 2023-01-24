package maker.grow;

public class Onion extends Crops {
	
	private String name = "양파";
	private final int FULL = 120;
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getFULL() {
		return FULL;
	}
	
	@Override
	public boolean finish() {

		boolean result = false;

		if(super.getEnergy() >= FULL) {
			result = true;
		}

		return result;
	}

}
