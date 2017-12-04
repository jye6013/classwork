package algorithms;

import java.util.Scanner;

public class TowersOfHanoi {
	
	public static void solve(int n, String start, String helper, String end) {
	       if (n == 1) {
	           System.out.println(start + " -> " + end);
	       } else {
	           solve(n - 1, start, end, helper);
	           System.out.println(start + " -> " + end);
	           solve(n - 1, helper, start, end);
	       }
	   }

	   public static void main(String[] args) {
	       solve(30, "A", "B", "C");
	   }
}
