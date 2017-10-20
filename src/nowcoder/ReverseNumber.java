package nowcoder;

import java.util.Scanner;

/**
 * Created by SZ on 2017/8/11.
 * 题目描述
 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 如果 X = 123，则rev(X) = 321;
 如果 X = 100，则rev(X) = 1.
 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
 输入描述:
 输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
 输出描述:
 输出rev(rev(x) + rev(y))的值
 示例1
 输入

 123 100
 输出

 223
 */
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next(), y = sc.next();
        int len = Math.max(x.length(), y.length()) + 1, i = 0;
        int[] res = new int[len];
        for(; i < Math.min(x.length(), y.length()); i++) {
            res[i] += (x.charAt(i) - '0') + (y.charAt(i) - '0');
            if(res[i] >= 10) {
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
        }
        while(i < x.length()) {
            res[i] += x.charAt(i) - '0';
            if(res[i] > 10) {
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
            i++;
        }
        while(i < y.length()) {
            res[i] += y.charAt(i) - '0';
            if(res[i] > 10) {
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
            i++;
        }
        i = 0;
        int j = res.length - 1;
        while(res[i] == 0) {i++;};
        while(res[j] == 0) {j--;};
        for(;i <= j; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
