package nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by SZ on 2017/8/9.
 */

/**
 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 */
public class LuckBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt(), sum = 0;
            int[] nums = new int[n];
            long prd = 1;
            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(bc(nums, 0, sum, prd));
        }
    }

    public static int bc(int[] nums, int i, int sum, long prd) {
        if(i == nums.length) {
            return sum > prd ? 1 : 0;
        }
        int end = i + 1;
        while(end < nums.length && nums[end] == nums[i]) { end++; };
        int s = 0, p = 1, count = 0;
        //all exclude
        count += bc(nums, end, sum, prd);
        //include
        for(int index = i; index < end; index++) {
            s += nums[index];
            p *= nums[index];
            if(sum + s < prd * p) break;
            count += bc(nums, end, sum + s, prd * p);
        }
        return count;
    }
}
