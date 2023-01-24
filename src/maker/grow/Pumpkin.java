package maker.grow;

public class Pumpkin extends Crops {

	private String name = "호박";
	private final int FULL = 150;
	
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
