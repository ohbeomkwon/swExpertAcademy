package d3_1204_mode;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		int N = 1000;		// 학생수는 1000명
		int M = 100;	// 최고점수는 100점
		while(T++<testCase) {
			sc.nextInt();
			int[] grade = new int[M+1];
			for(int i=0; i<N; i++) {
				int g = sc.nextInt();
				grade[g]++;
			}
			
			int maxGrade = -1;
			int maxIndex=-1;
			for(int i=0; i<=M; i++) {
				if(grade[i]>=maxGrade) {
					maxGrade = grade[i];
					maxIndex = i;
				}
			}
			
			System.out.println("#"+T+" "+maxIndex);
			
		}
		sc.close();
	}
}
