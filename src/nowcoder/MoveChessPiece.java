package nowcoder;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by SZ on 2017/9/5.
 */
public class MoveChessPiece {


    private static PriorityQueue<Long> q = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] x = new int[n], y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = sc.nextInt();
            }
            StringBuilder sb = new StringBuilder("0");
            for (int k = 2; k <= n; k++) {
                long num = Long.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        num = Math.min(num, findMinDist(x[i], y[j], x, y, k));
                    }
                }
                sb.append(" ").append(num);
            }
            System.out.println(sb.toString());
        }
    }

    private static long getManhattanDist(int x0, int y0, int x1, int y1) {
        return  Math.abs(x0 - x1) + Math.abs(y0 - y1);
    }

    private static long findMinDist(int x0, int y0, int[] x, int[] y, int k) {
        int len = x.length;
        long res = 0, dist;
        for (int i = 0; i < len; i++) {
            dist = getManhattanDist(x0, y0, x[i], y[i]);
            q.offer(-dist);
            if(i >= k) {
                q.poll();
            }
        }
        while (!q.isEmpty()) {
            res -= q.poll();
        }
        return res;
    }
}
