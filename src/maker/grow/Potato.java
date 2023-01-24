package maker.grow;

public class Potato extends Crops {
	
	private String name = "감자";
	private final int FULL = 100;

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
