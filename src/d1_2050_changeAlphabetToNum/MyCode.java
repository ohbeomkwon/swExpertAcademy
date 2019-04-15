package d1_2050_changeAlphabetToNum;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String alphabet = sc.nextLine();
		int len = alphabet.length();
		int[] nums = new int[len];
		for(int i=0; i<len; i++) {
			nums[i] = alphabet.substring(i, i+1).charAt(0)-64;
		}
		
		for(int i=0; i<len; i++) {
			System.out.print(nums[i]+" ");
		}
		
//		A의 아스키코드값이 65. 따라서 -64를 해주고 출력하면됨.
		
		sc.close();
	}
}
