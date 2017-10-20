package nowcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by SZ on 2017/8/11.
 * 题目描述
 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 while(!Q.empty())              //队列不空，执行循环

 {

 int x=Q.front();            //取出当前队头的值x

 Q.pop();                 //弹出当前队头

 Q.push(x);               //把x放入队尾

 x = Q.front();              //取出这时候队头的值

 printf("%d\n",x);          //输出x

 Q.pop();                 //弹出这时候的队头

 }

 做取出队头的值操作的时候，并不弹出当前队头。
 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正]
 输入描述:
 第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
 输出描述:
 对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
 */
public class ConstructQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n;
        int[] nums;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            n = sc.nextInt();
            nums = solve(n);
            for(int num : nums) {
                if(sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(num);
            }
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    private static int[] solve(int n) {
        int[] res = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int i = 1;
        while(!queue.isEmpty())              //队列不空，执行循环
        {
            int x = queue.poll();            //取出当前队头的值x

            queue.offer(x);               //把x放入队尾

            x = queue.poll();              //取出这时候队头的值

            res[x - 1] = i++;
        }
        return  res;
    }
}
