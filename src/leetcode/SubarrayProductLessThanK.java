package leetcode;

import java.util.Arrays;

/**
 * Created by SZ on 2017/10/22.
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] >= k) continue;
            int prod = nums[i];
            count++;
            for (int j = i + 1; j < len; j++) {
                prod *= nums[j];
                if(prod < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK productLessThanK = new SubarrayProductLessThanK();
        int[] arr = {10, 5, 2, 6};
        System.out.println(productLessThanK.numSubarrayProductLessThanK(arr, 100));
    }

}
