package nowcoder;

import java.util.Scanner;

/**
 * Created by SZ on 2017/9/13.
 */
public class ChooseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            if(n < 3) {
                System.out.println(true);
                continue;
            }
            int[] dp = new int[n];
            dp[n - 1] = nums[n - 1];
            dp[n - 2] = dp[n - 1] + nums[n - 2];
            for (int i = n - 3; i >= 0 ; i--) {
                dp[i] = Math.max(nums[i] - dp[i + 1], nums[i] + nums[i + 1] - dp[i + 2]);
            }
            System.out.println(dp[0] >= 0);
        }
    }

}
