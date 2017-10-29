package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by SZ on 2017/10/29.
 * Given an integer array, return the k-th smallest distance among all the pairs.
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = (low + high) >> 1;
            int count = finCount(nums, mid);// <= mid
            if(count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int finCount(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] - nums[i] <= mid) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
