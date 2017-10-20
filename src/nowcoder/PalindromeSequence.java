package nowcoder;

import java.util.Scanner;

/**
 * Created by SZ on 2017/8/11.
 * 题目描述
 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 现在给出一个数字序列，允许使用一种转换操作：
 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 输入描述:
 输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50)
 第二行为序列中的n个整数item[i]  (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
 输出描述:
 输出一个数，表示最少需要的转换次数
 */
public class PalindromeSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if(nums[i] == nums[j]) {
                    dp[i][j] = j - i == 1 ? 0 : dp[i + 1][j - 1];
                } else {
                    int l = i, h = j, a = nums[i], b = nums[j];
                    while(l < h) {
                        while(l < h && a < b) { a += nums[++l]; }
                        if(a == b){
                            dp[i][j] = l - i + h - j + dp[l + 1][h - 1];
                            break;
                        }
                        while (l < h && b < a) {b += nums[--h];}
                        if(a == b) {
                            dp[i][j] = l - i + j - h + dp[l + 1][h - 1];
                            break;
                        }
                    }
                    if(a != b) dp[i][j] = j - i;
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
