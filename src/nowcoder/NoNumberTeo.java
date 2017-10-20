package nowcoder;

/**
 * Created by SZ on 2017/8/10.
 */

import java.util.Scanner;

/***
 * 题目描述
 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 小易想知道最多可以放多少块蛋糕在网格盒子里。
 输入描述:
 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
 */
public class NoNumberTeo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int w = sc.nextInt(), h = sc.nextInt(),sum = 0, m = w % 4, n = h % 4;
            sum += (w >> 2) * (h >> 2) * 8;
            if(m > 0) sum += (h >> 2) * m * 2;
            if(n > 0) sum += (w >> 2) * n * 2;
            if(m * n  < 2) sum += m * n;
            else if(m * n  < 4) sum += 2;
            else if(m * n  < 9) sum += 4;
            else sum += 5;
            System.out.println(sum);
        }
    }

    public static int bc(boolean[][] takes, int i, int j) {
        if(i == takes.length ) return 0;
        if(j == takes[i].length) return bc(takes, i + 1, 0);
        int not = bc(takes, i , j + 1);
        if((i - 2 >= 0 && takes[i - 2][j]) || (j - 2 >= 0 && takes[i][j - 2])) {
            return not;
        }
        takes[i][j] = true;
        int take = 1 + bc(takes, i , j + 1);
        takes[i][j] = false;
        return Math.max(not, take);
    }
}
