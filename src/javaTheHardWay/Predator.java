package javaTheHardWay;

public class Predator extends ReproductionAnimal{
	//public void act
	//public void canEat
	//public void mate
	
	public Predator(Habitat matingArea) {
		super(matingArea);
		setMaxLitterSize(3);
	}
	
	public Predator(Habitat matingArea, String description, Trait trait1, Trait trait2) {
		super(matingArea, description, trait1, trait2);
		setMaxLitterSize(3);
	}
	
	public static final String[] PREDATORS = {"wolf", "bear", "lion", "bobcat"};
	
	public String getName() {
		return PREDATORS[(int)(Math.random()* PREDATORS.length)];
	}
	
	public static void main(String[] args) {
		Wilderness wilderness = new Wilderness("A Wooded Area", 10); 
			Predator p = new Predator(wilderness);
			wilderness.addAnimal(p);
			wilderness.simulate(2);
	}
	
	public ReproductionAnimal getOffspring(ReproductionAnimal mate) {
		return new Predator(habitat, getDescription(),
				Trait.getDominantTrait(getTrait1(), getTrait2()),
				Trait.getDominantTrait(getTrait2(), getTrait1()));
	}
	
	public boolean canEat() {
		int attempts = 0;
		while(attempts < 3) {
			int tIndex = (int)(Math.random()* habitat.getAnimals().length);
			Animal target = habitat.getAnimals()[tIndex];
			if(target instanceof Prey) {
				habitat.removeAnimal(tIndex);
				return true;
			}
			attempts++;
		}
		return false;
	}
}
