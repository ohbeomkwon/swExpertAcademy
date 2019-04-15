package d2_1859_millionaireProject;

import java.util.Scanner;

public class MyCode {		// 정답
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase=sc.nextInt();
		int T=0; 
		while(T++<testCase) {
			int N = sc.nextInt();
			int[] day = new int[N];
			for(int i=0; i<N; i++) {
				day[i] = sc.nextInt();
			}
			int len = day.length;
			long buyPrice =0;
			long buyAmount = 0;
			long profit=0;
			// 곱해졌을 때 숫자가 커지는 것에 유의할 것 (최대값 10,000,000,000 백억으로 int의 범위를 넘어섬)
			
			int startIndex = 0;
			int maxIndex = -1;
			
			while(startIndex < len) {
				// 돌릴지 말지 결정
				maxIndex = findMaxIndex(startIndex, day);
//				System.out.println("maxIndex "+maxIndex);
				if(startIndex==maxIndex) {
					startIndex++;		// 두 값이 같다면 스타드만 한칸 이동해준다.
					continue;		// startIndex와 maxIndex가 같다면 다시 루프를 돈다
				}
				//산다
				for(int i=startIndex; i<maxIndex; i++) {
					buyPrice += day[i];		// 구매한 가격을 더해준다.
					buyAmount++;				// 구매한 갯수를 더해준다.
				}
				// 판다
				profit += buyAmount * day[maxIndex] - buyPrice;
				// 초기화
				buyPrice = 0;
				buyAmount = 0;
				startIndex = maxIndex+1;
			}
			System.out.println("#"+T+" "+profit);
			
		}
		sc.close();
	}
	public static int findMaxIndex(int startIndex, int[] day){
		int maxIndex=-1;
		int max=-1;
		for(int i=startIndex; i<day.length; i++) {
			if(day[i]==Math.max(max, day[i])) {
				maxIndex = i;
				max = day[i];
			}
		}
		return maxIndex;
	}
}
