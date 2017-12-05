package algorithms;

public class ReverseString {
	private static String reverse = "";
	private static String characters = "example";
	
	public static void main(String[] args) {
		reverseString(characters);
	}
	 
	public static String reverseString(String str) {
		if(str.length() == 1) {
			reverse += str;
		}else {
			reverse += str.substring(str.length() -1, str.length()) +
			reverseString(str.substring(0, str.length()-1));
		}
		return reverse;
	}
	
	//str.substring(1)) + str.charAt(0
	/*
	public int length() {
		return str.length();
	}
	
	public String substring(int beginIndex, int endIndex) {
		return str.substring(beginIndex, endIndex);
	}	
	*/
}
