package hihocoder;

import java.util.Scanner;

public class Bag{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] value = new int[n];
        int[] need = new int[n];
        for(int i = 0; i < n; i++) {
            scanner.nextLine();
            need[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        int[] dp = new int[m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= need[i]; j--) {
            	dp[j] = Math.max(dp[j], dp[j - need[i]] + value[i]);
            }
        }
        System.out.println(dp[m]);
    }
/**
 *  5 1000
144 990
487 436
210 673
567 58
1056 897
2099
 */
}
