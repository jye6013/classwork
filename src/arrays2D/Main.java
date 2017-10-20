package arrays2D;

public class Main {

	public static void main(String[] args) {
		//int[] arr = {4, 3, 2, 1, 0};
		//changeNeighbors(arr, 2);
		//String[][] picture = new String[10][20];
		//printPicture(picture);
		Array2DSampler test = new Array2DSampler();
	}

	/**
	 * PRECONDITION: i >= 0 and i < arr.length
	 * increases the element at i by 1
	 * decreases the elements at i - 1 and i + 1, if they exist
	 * AVOIDS ArrayIndexOutOfBoundsException
	 * THIS IS SUCH A HEAVILY TESTED CONCEPT, 
	 * on every exam, you should always be in the habit of checking for
	 * ArrayIndexOutOfBoundsExceptions
	 * Trust me, don't be "that guy" who lose a bazillion points
	 * @param arr
	 * @param i
	 */
	private static void changeNeighbors(int[] arr, int i) {
		arr[i] = arr[i] + 1;
		
		if(i < arr.length && i >= 0) {
			arr[i-1] = arr[i] -1;
		}
		
		if (i <= arr.length) {
			arr[i] = arr[i] + 1;
		}
	}

}
