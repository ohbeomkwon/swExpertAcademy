package d3_1240_easyBinaryCode;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			int N = sc.nextInt();		// 입력배열의 세로길이
			int M = sc.nextInt();		// 입력배열의 가로길이
			sc.nextLine();
			String[] s = new String[N];
			for(int i=0; i<N; i++) {
				s[i] = sc.nextLine().trim();
			}
			
			String extract = "";
			out:
			for(int i=0; i<N; i++) {
				if(s[i].contains("1")) {
					char[] c = s[i].toCharArray();
					for(int j=c.length-1; j>=0; j--) {
						if(c[j]=='1') {
							extract = s[i].substring(j-55, j+1);
							break out;
						}
					}
				}
//				if(Integer.parseInt(s[i])==0) {
//					continue;
//				}
//				else {
//					char[] c = s[i].toCharArray();
//					for(int j=c.length-1; j>=0; j--) {
//						if(c[j]=='1') {
//							extract = s[i].substring(j-55, j+1);
//							break out;
//						}
//					}
//				}
//				try {
//					if(Integer.parseInt(s[i])==0) {
//						continue;
//					}
//				} catch (Exception e) {
//					char[] c = s[i].toCharArray();
//					for(int j=c.length-1; j>=0; j--) {
//						if(c[j]=='1') {
//							extract = s[i].substring(j-55, j+1);
//							break out;
//						}
//					}
//				}
			}
			
			int no1 = decode(extract.substring(0,7));
			int no2 = decode(extract.substring(7,14));
			int no3 = decode(extract.substring(14,21));
			int no4 = decode(extract.substring(21,28));
			int no5 = decode(extract.substring(28,35));
			int no6 = decode(extract.substring(35,42));
			int no7 = decode(extract.substring(42,49));
			int no8 = decode(extract.substring(49,56));
			
			int ans=0;
			int num = (no1+no3+no5+no7)*3 +(no2+no4+no6) +no8;
			if(num%10==0) { // 암호코드임
				ans = no1+no2+no3+no4+no5+no6+no7+no8;
			}
			
			System.out.println("#"+T+" "+ans);
		}
		
		
		sc.close();
	}
	
	public static int decode(String s) {
		int ans=0;
		switch (s) {
		case "0001101":
			ans = 0;
			break;
		case "0011001":
			ans = 1;
			break;
		case "0010011":
			ans = 2;
			break;
		case "0111101":
			ans = 3;
			break;
		case "0100011":
			ans = 4;
			break;
		case "0110001":
			ans = 5;
			break;
		case "0101111":
			ans = 6;
			break;
		case "0111011":
			ans = 7;
			break;
		case "0110111":
			ans = 8;
			break;
		case "0001011":
			ans = 9;
			break;
		}
		return ans;
	}
	
}
