package arrays;

import java.util.Arrays;

public class ArraysMain {

	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
		tuesdayMethods();
	}
	
	private void tuesdayMethods() {
		int[] orderTest = {1, 2, 3, 4, 5, 1, 6, 7, 8, 9, 10, 11};
//		cycleThrough(orderTest, 3);
//		System.out.println(Arrays.toString(orderTest));
		System.out.println(longestConsecutiveSequence(orderTest) + "  is longest LCS.");
		
	}
	
	/**
	 * return the length of the longest cons. sequence in the array
	 * for example:
	 * LCS({1, 2, 3, 2, 3, 4, 5, 2, 3 , 4}) -> 4
	 * @param arr
	 * @return
	 */
	private int longestConsecutiveSequence(int[] arr) {
		int maxLength = 1;
		int currentCount = 1;
		for(int i  = 0; i < arr.length; i++) {
			while (i+ currentCount < arr.length && isConsecutive(arr, i , i+currentCount)) {
				currentCount++;
			}
			if (currentCount > maxLength) {
				maxLength = currentCount;
			}
			i = i + currentCount-1;
			currentCount = 1;
		}
		return maxLength;
		/*
		int tempCount = 0;
		int recentIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if (ifConsecutive(i, i+1)) {
				tempCount++;
			}
			if(tempCount > totalCount) {
				totalCount = tempCount;
			}
		}
		return totalCount;
		*/
	}
	
	private boolean ifConsecutive(int x,int y) {
		if (x + 1 == y) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns true if all the elements from start to end are increasing by 1
	 * example:
	 * iC ({1, 7, 3, 6, 7, 8, 12} 3, 5) -> true
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	
	private boolean isConsecutive(int[] arr, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(arr[i] +1 != arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * the element at index 0 moves to the last position in the array 
	 * as all other elements move forward. this must happen exactly n times
	 * @param orderTest
	 * @param n
	 */
	private void cycleThrough(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			frontToBack(arr);
		}
	}

	/**
	 * removes the element at index 0, pushes all the other elements
	 * forward: 1 goes to 0, 2 goes to 1 ...
	 * puts the element that was index 0 at end
	 * @param arr
	 * @return
	 */
	private void frontToBack(int[] arr) {
		int x = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = x;
	}

	private void warmUpMethods() {
		int[] orderTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		reverseOrder(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(Arrays.toString(subArray(orderTest, 3, 4)));
	}

	void reverseOrder(int[] arr) {
		for(int i = 0; i < arr.length/2; i++) { //divide 2?
			swap(arr, i, arr.length-1-i);
		}
	}
	
	int[] subArray(int[] arr, int psn, int length) {
		int[] sub = new int[length]; 
		for(int i = 0; i < length; i++) {
			sub[i] = arr[i+psn];
		}
		return sub;
	}
	
	public void cardMethods() {
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		values = new String[13];
		for(int i = 0; i < values.length; i++) {
			values[i] = "" + (i+1);
		}
		values[0] = "Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
		
		//System.out.println(Arrays.toString(testArray));
	}
	
	private String[] printDeck() {
		String[] deck = new String[52];
		int index = 0;
		for(String suit: suits) {
			for(String value: values) {
				deck[index] = value + " of " + suit;
				index++;
			}
		}
		return deck;
		
	}

	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr, i, (int)(Math.random() * arr.length));
		}		
	}

	/**
	 * Swaps elements at i and j
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int placeholder = arr[i];
		arr[i] = arr[j];
		arr[j] = placeholder;
		
	}

	/**
	 * Populate arr with numbers 1 to arr.length, in order
	 * @param testArray2
	 */
	private void populate1ToN(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1);
		}
		
	}

	private void countOccurences(int[] arr, int start, int end) {
		//why create an array with this length?
		int[] counter = new int[end - start +1];
		for(int value: arr) {
			//why value - start?
			counter[value - start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("The value " + (i+start) + " was rolled " + counter[i] + " times.");
		}
	}

	/**
	 * This method populates arr with results from rolling 2 dice
	 * @param arr
	 */
	private void populate(int[] arr) {
		//correct way:
		for(int i = 0; i < arr.length; i++) {
		arr[i] = diceRoll(3);
		}
		//incorrect way: (does nothing):
		//for(int value: arr) {
		//	value = diceRoll(2);
		//}
	}

	public void arrayNotes() {
		//two ways to construct an array:
		int[] firstWay = {0, 1, 2, 3, 4, 5};
		//this way will only work with the declaration
		//will not work:
		//firstWay = {6, 7, 8, 9, 10};
				
		String[] secondWay = new String[5];
		//you can go on like so, creating values at each index:
		//secondWay[0] = 1;
		//secondWay[1] = 10;
				
		//TWO WAYS TO ITERATE THROUGH AN ARRAY:
		for(int i = 0; i < secondWay.length; i++) {
			System.out.println("The #" + i + " element is " + secondWay[i]);
		}
		//"For eaech int in secondWay"
		for(String value: secondWay) {
			System.out.println("Element is " + value);
		}
		//NOTE: primitive arrays are auto-populated with 0s
		//Object arrays are not populated (null)
	}
	
	public static void main(String[] args) {
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and Objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		
		//2. Size cannot be edited
		
		/*3. Elements of an array are REFERENCES to objects. In
		 * other words, changing an element of an array changes the
		 * reference, not the object.
		 */
	}
	
	public int diceRoll(int n) {
		int sum = 0;
		for(int i = 0; i < n ; i++) {
			int dieRoll = (int)(Math.random() * 6) +1;
			sum += dieRoll;
		}
		return sum;
	}
}