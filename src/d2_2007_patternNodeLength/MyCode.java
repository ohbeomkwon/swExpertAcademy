package d2_2007_patternNodeLength;

import java.util.Scanner;

// 패턴마디의 길이를 출력하는 문제. 
//	마디의 최대길이는 10. 문자열의 길이는 무조건30.
// 문자열 길이가 정해져있으므로 중간에 다른 패턴이 들어가지 않는다는 가정하에
// 10마디부터 줄여서 보자.
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		int T=0;
		
		while(T++<testCase) {
			String s = sc.nextLine();
			
			int maxNode = findMaximumNode(s);
			System.out.println("#"+T+" "+maxNode);
		}
		sc.close();
	}
	
	public static int findMaximumNode(String string) {
		int maxNode=1;
		here:
		for(int i=0; i<string.length();i++) {
			int node =1;
			for(int j=i+node; j<string.length(); j++) {
				if(node>10 || j+node > string.length()) break here;
				String a = string.substring(i,j);
				String b = string.substring(j,j+node);
				if(a.equals(b)) {
					maxNode=Math.max(node, maxNode);
					return maxNode;
				}
				else {
					node++;
				}
			}
		}
		return maxNode;
	}
}
