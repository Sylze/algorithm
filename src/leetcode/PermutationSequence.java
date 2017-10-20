package leetcode;

import java.util.LinkedList;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		int fact = 1;
		for (int i = 2; i <= n; i++)
			fact *= i; // factorial

		StringBuilder strBuilder = new StringBuilder();
		for (k--; n > 0; n--) {
			fact /= n;
			strBuilder.append(list.remove(k / fact));
			k %= fact;
		}

		return strBuilder.toString();
	}

	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 4));
	}

}
