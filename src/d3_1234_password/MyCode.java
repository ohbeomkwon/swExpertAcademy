package d3_1234_password;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T = 0;
		List<Character> list;
		while (T++ < testCase) {
			int N = sc.nextInt(); // 문자열의 총 길이
			String num = sc.nextLine().trim();
			char[] c = num.toCharArray();
			list = new ArrayList<>();
			for (int i = 0; i < c.length; i++) {
				list.add(c[i]);
			}
			for (int i = 0; i < list.size() - 1; i++) {
				while (true) {
					if(i+1 > list.size()-1)		break;
					if (list.get(i).equals(list.get(i + 1))) {
						list.remove(i);
						list.remove(i);
						if(i!=0) {
							i--;
						}
					}
					else {
						break;
					}
				}
			}

			System.out.println("#" + T + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();

		}
		sc.close();
	}
}
