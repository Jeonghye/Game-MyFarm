package maker.grow;

public class Crops implements GrowCrops{
	
	private int energy = 0;
	private final int FULL = 100;
	public String name;
	
	public String getName() {
		return name;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public int getFULL() {
		return FULL;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	@Override
	public void water() {
		energy += 50;
		System.out.println("물뿌리개로 물을 준다. +50");
		System.out.println("현재 에너지 : " + energy);
		
	}

	@Override
	public void await() {
		energy += 20;
		System.out.println("어서 자라기를 기다린다. +20");
		System.out.println("현재 에너지 : " + energy);
		
	}

	@Override
	public void cheer() {
		energy += 30;
		System.out.println("어서 자라도록 응원한다. +30");
		System.out.println("현재 에너지 : " + energy);
		
	}
	
	public boolean finish() {
		
		boolean result = false;
		
		if(energy == FULL) {
			result = true;
		}
		
		return result;
	}
	
}