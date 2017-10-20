package hihocoder;

import java.util.Scanner;

public class LuckNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		for(int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			System.out.println(findLuckNum(num));
			scanner.nextLine();
		}
	}

	private static String findLuckNum(int num) {
		int w = (int) (Math.log(num/2 + 1)/Math.log(2));//最小位数
		StringBuilder sb = new StringBuilder();
		help(num, w, sb);
		return sb.toString();
	}

	private static void help(int num, int w, StringBuilder sb) {
		if(num == 1) {
			sb.append('4');
		} else if(num == 2) {
			sb.append('7');
		} else {
			int pow = (int) Math.pow(2, w);
			int preSum = (pow - 1) * 2;
			int dif = num - preSum;
			
			if(dif == 0) {
				sb.append('7');
				num -= pow;
			} else if(dif <= pow) {
				sb.append('4');
				num -= pow;
			} else {
				sb.append('7');
				num-= 2*pow;
			}
			w--;
			help(num, w, sb);
		}
	}
}
