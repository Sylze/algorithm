package leetcode;

public class EditDistance {
	
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[] dp = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			dp[i] = i;
		}
		int pre = dp[0], temp;
		for(int i = 1; i <= m; i++) {
			dp[0] = i;
			for(int j = 1; j <= n; j++) {
				temp = dp[j];
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[j] = pre;
				} else {
					dp[j] = Math.min(Math.min(pre + 1, dp[j] + 1), dp[j - 1] + 1);
				}
				pre = temp;
			}
			pre = dp[0];
		}
        return dp[n];
    }

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance("abcd", "bcd"));
		System.out.println(ed.minDistance("bcd", "abcd"));
		System.out.println(ed.minDistance("bc", "cb"));
	}

}
