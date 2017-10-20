package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SZ on 2017/10/15.
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        int max = 0, len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            Node v = map.get(nums[i]);
            if(v == null) {
                v = new Node();
                v.start = i;
            }
            v.end = i;
            v.count++;
            max = Math.max(max, v.count);
            map.put(nums[i], v);
        }
        for (Node node : map.values()) {
            if(max == node.count) {
                len = Math.min(len, node.end - node.start);
            }
        }
        return len + 1;
    }

    class Node {
        int count;
        int start;
        int end;
    }
}
