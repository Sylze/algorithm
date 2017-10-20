package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by SZ on 2017/8/11.
 */
public class ShuffleCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n, k;
        int[] nums;
        System.out.println();
        for(int i = 0; i < t; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            nums = new int[2 * n];
            for(int j = 0; j < 2 * n; j++) {
                nums[j] = sc.nextInt();
            }
            int[] solve = solve(nums, k);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < solve.length; j++) {
                if(sb.length() > 0) sb.append(" ");
                sb.append(solve[j]);
            }
            System.out.println(sb.toString());
        }
    }

    private static int[] solve(int[] nums, int k) {
        int[] res = new int[nums.length], a = nums, b = res, tmp;
        for (int i = 0; i < k; i++) {
            int m = (a.length >> 1) - 1,
                n = a.length - 1,
                index = b.length - 1;
            while (m >= 0) {
                b[index--] = a[n--];
                b[index--] = a[m--];
            }
            res = b;
            tmp = a;
            a = b;
            b = tmp;
        }
        return res;
    }
}
