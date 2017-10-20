package leetcode;

import java.util.Arrays;

/**
 * Created by SZ on 2017/9/11.
 */
public class LIS {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length, max = 0, res = 0;
        int[] dp = new int[len], count = new int[len];
        for(int i = 0; i < len; i++) {
            dp[i] = count[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    } else if(dp[i] < dp[j] + 1) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        count[i] = count[j];
                    }
                }
            }
            if(dp[i] == max) {
                res += count[i];
            } else if(dp[i] > max) {
                max = dp[i];
                res = count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};
        LIS lis = new LIS();
        System.out.println(lis.findNumberOfLIS(arr));
        System.out.println(lis.lengthOfLIS(arr));
    }
}
