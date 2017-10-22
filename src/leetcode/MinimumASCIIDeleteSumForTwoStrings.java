package leetcode;

/**
 * Created by SZ on 2017/10/22.
 */
public class MinimumASCIIDeleteSumForTwoStrings {

    /**
     * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
     * Input: s1 = "sea", s2 = "eat"
     * Output: 231
     * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
     * Deleting "t" from "eat" adds 116 to the sum.
     * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        }
        for (int i = 0; i < len2; i++) {
            dp[0][i + 1] = dp[0][i] + s2.charAt(i);
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int cost = s1.charAt(i) == s2.charAt(j) ? 0 : s1.charAt(i) + s2.charAt(j);
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + s1.charAt(i), dp[i + 1][j] + s2.charAt(j));
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + cost);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteSumForTwoStrings obj = new MinimumASCIIDeleteSumForTwoStrings();
        System.out.println(obj.minimumDeleteSum("eat", "sea"));
    }
}
