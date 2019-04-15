package d2_1983_setGrade;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Float, Integer> score;
		Map<Integer, String> gradeScore;
		// 총점과 학생번호를 연결
		int testCase = sc.nextInt();
		int T = 0;
		String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
		while (T++ < testCase) {
			int N = sc.nextInt(); // 학생 수
			int K = sc.nextInt(); // 알고싶은 학생의 번호
			// 총점 = 중간(35)+기말(45)+과제(20)

			score = new HashMap<>();
			float[] season = new float[N];
			for (int i = 0; i < N; i++) {
				float midExam = sc.nextInt();
				float finalExam = sc.nextInt();
				float paper = sc.nextInt();
				float seasonScore = (float) (midExam * 0.35 + finalExam * 0.45 + paper * 0.2);
				score.put(seasonScore, i + 1);// 총점 학생번호
				season[i] = seasonScore;
			}
			Arrays.sort(season);
			int per = N / 10; // 몇명에게 동일한 학점을 줄 수 있는가
			gradeScore = new HashMap<>();
			for (int i = 0; i < N; i++) {
				Integer studentNumber = score.get(season[i]);// 학생번호
				String g = grade[i / per];
				gradeScore.put(studentNumber, g);
			}
			String ans = gradeScore.get(K);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
}
