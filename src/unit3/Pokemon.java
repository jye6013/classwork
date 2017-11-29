package unit3;

public class Pokemon {
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String name1, int level1) {
		hp = 100;
		name = name1;
		level = level1;
		poisoned = false;
	}
	
	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {
		 
		public void attack(Pokemon target) {
		int hp = target.getHP();
		target.setHP(hp/2);
		}
		});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {
		 
		public void attack(Pokemon target) {
		target.setPoisoned(true);
		}
		});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
		System.out.println("Squirtle is attacking again!");
		squirtle.attack(bulbasaur, new Attack() {
			 public void attack(Pokemon target) {
				 int hp = target.getHp();
				 target.setHp(hp-100);
			 }
		});
		squirtle.levelUp(new Effect() {
			
			public void happen() {
				//code hoes here
				//final if you wan to  modifly a reference
				squirtle.setHp(100);
			}
		});
	}

	private int getHp() {
		return hp;
	}

	private void setHp(int i) {
		this.hp = i;
	}

	private int getHP() {
		return hp;
	}

	private static void printScore(Pokemon squirtle, Pokemon bulbasaur) {
		System.out.println(p1.getName() + ", HP = " + p1.getHp());
		System.out.println(p2.getName() + ", HP = " + p2.getHp());
		
	}

	private void setHP(int i) {
		this.hp = i;
		
	}

	void iChooseYou() {
		System.out.println(name + ", " + name + "!");
	}
	
	public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9) {
			 attack.attack(target);
			 System.out.println("The attack hit.");
		 }	else{
		 System.out.println("The attack missed.");
		 }
	}
	
	private String getName() {
		return name;
	}
	
	public void levelUp(Effect e) {
		level++;
		e.happen();
	}
	
	private void setPoisoned(boolean b) {
		if(b == true) {
			poisoned = false;
		}else {
			poisoned = true;
		}
	}
	
	private void lapse() {
		if(poisoned) {
			hp = hp - 15;
		}
	}
}


