package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by SZ on 2017/8/11.
 * \题目描述
 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
 例如：
 N = 4，M = 24：
 4->6->8->12->18->24
 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
 输入描述:
 输入为一行，有两个整数N，M，以空格隔开。
 (4 ≤ N ≤ 100000)
 (N ≤ M ≤ 100000)
 输出描述:
 输出小易最少需要跳跃的步数,如果不能到达输出-1
 */
public class JumpStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] dp = new int[m + 1];
        Arrays.fill(dp, n + 1, m + 1, Integer.MAX_VALUE);
        for(int i = n; i < m - 1; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            for(int j = 2, next; j <= Math.sqrt(i) && j <= m - i; j++) {
                if(i % j == 0) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    next = i / j;
                    if(next != j && i + next <= m) {
                        dp[i + next] = Math.min(dp[i + next], dp[i] + 1);
                    }
                }
            }
        }
        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
     }
}
