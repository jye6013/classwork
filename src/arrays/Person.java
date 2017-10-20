package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "Am", "L", "D", "Th", "Br", "B"};
	public static final String[] FIRST_MIDDLE = {"ala", "ima", "e", "o", "a", "anna", "ola", "a"};
	public static final String[] FIRST_END = {"na", "ck", "n", "tt", "rian", "lius", "lion", "les", "a"}; 
	
	public static final String[] LAST_START = {"Bl", "Gr", "Ph", "M", "Thr", "Sh", "Br"};
	public static final String[] LAST_MIDDLE = {"an", "in", "ast", "own", "il"};
	public static final String[] LAST_END = {"strom", "son", "rack", "les", "vin", "ston"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
		nickname = createNickname(firstName);
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * PASS BY VALUE
	 * the parameters of a method contains only values, not references
	 * therefore, when they are changed, the REFERENCE to the original
	 * object does not change
	 * 
	 * returns a String equal to the name up to the index of (but not including
	 * the 2nd vowel
	 * createNickname("Jonathan") -> "Jon"
	 */
	
	public static String createNickname(String name) {
		String nickname = "";
		int vowelCount = 0;
		for(int i = 0; i < name.length(); i++) {
			String letter = name.substring(i, i+1);
			if(isVowel(letter)) {
				vowelCount++;
				if(vowelCount != 2) {
					nickname += letter;
				}
				else {
					return nickname;
				}
			}
			else {
				//add the letter when not vowel
				nickname += letter;
			}
		}
		return name;
	}
	
	private static boolean isVowel(String letter) {
		letter = letter.toLowerCase();
		return letter.equals("e") || letter.equals("a") || letter.equals("o")
				|| letter.equals("i") || letter.equals("u");
	}
	
	/**
	 * when called, states "My friends are..."
	 * and lists all Persons in friends, separated by comma
	 * expect last friend, which is preceded by 'and'
	 */
	
	public void stateYourFriends() {
		String statement = "My friends are "; 
		for(int i = 0; i < friends.length-1; i++) {
			statement += friends[i].firstName + " " + friends[i].lastName + ",";
		}
		statement += " and " + friends[friends.length-1];
		System.out.println(statement);
	}
	
	public void mingle(Person[] peers) {
		for(Person p: peers) {
			//you cannot friend yourself
			if(p != this) {
				setInFirstPlace(p);
			}
		}
	}
	
	public void setInFirstPlace(Person f) {
		//go backward through an array
		for(int i = friends.length - 1; i > 0; i--) {
			//move the friend from in front, back
			friends[i] = friends[i-1]; //CHECK: Does not go out of bounds
		}
		friends[0] = f;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + 
				lastName + ". Call me " + nickname + ". and I am from " + home + ".";
	}
}
