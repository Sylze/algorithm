package leetcode;

/**
 * Created by SZ on 2017/10/29.
 * <p>
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length, max = 0;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray obj = new MaximumLengthOfRepeatedSubarray();
        int[] A = {0, 1, 1, 1, 1};
        int[] B = {1, 0, 1, 0, 1};
        System.out.println(obj.findLength(A, B));
    }
}
