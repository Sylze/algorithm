package nowcoder;

import java.util.Scanner;

/**
 * Created by SZ on 2017/8/12.
 * 份试卷
 */
public class Subsection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), sum = 0;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                sum += nums[i];
            }
            boolean hasHalf = false;
            int half = sum / 2;
            for (int i = 0; i < n; i++) {
                //如果有一个组的人数超过了和的一半，那么这个组必定分到自己组的卷子
                if(nums[i] > half) {
                    hasHalf = true;
                    break;
                }
            }
            if(hasHalf) {
                System.out.println("No");
                continue;
            }
            //否则，按组中人数大小排序，从大到小分卷即可
            System.out.println("Yes");
        }
    }
}
