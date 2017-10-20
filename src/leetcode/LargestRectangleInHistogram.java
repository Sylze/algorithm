package leetcode;

import java.util.Stack;

/**
 * Created by SZ on 2017/8/31.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length, i = 0, maxArea = 0;
        Stack<Integer> s = new Stack<>();
        while(i < len) {
            if(s.isEmpty() || heights[s.peek()] <= heights[i]) {
                s.push(i++);
            } else {
                int top = s.pop();
                maxArea = Math.max(maxArea, heights[top] * (s.isEmpty() ? i : i - s.peek() - 1));
            }
        }
        while (!s.isEmpty()) {
            int top = s.pop();
            maxArea = Math.max(maxArea, heights[top] * (s.isEmpty() ? i : i - s.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
        int[] nums = {6, 2, 5, 4, 5, 1, 6 };
        System.out.println(lrih.largestRectangleArea(nums));
    }
}
