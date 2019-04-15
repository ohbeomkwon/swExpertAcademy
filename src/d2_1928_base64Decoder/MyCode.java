package d2_1928_base64Decoder;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;


// decode하는 문제. 전혀모름... 정답보고 품..
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		int T=0;
		while(T++<testCase) {
			String s = sc.nextLine();
			Decoder decoder = Base64.getDecoder();
			byte[] code = decoder.decode(s);
			
			String ans = new String(code);
			System.out.println("#"+T+" "+ans);
			
		}
		sc.close();
	}
}
