package leetcode;

/**
 * Created by SZ on 2017/8/29.
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

 You need to return the number of important reverse pairs in the given array.

 Example1:

 Input: [1,3,2,3,1]
 Output: 2
 Example2:

 Input: [2,4,3,5,1]
 Output: 3
 Note:
 The length of the given array will not exceed 50,000.
 All the numbers in the input array are in the range of 32-bit integer.
 */
public class ReversePairs {

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
//        int[] nums = {1,3,2,3,1};
        ReversePairs rp = new ReversePairs();
        System.out.println(rp.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        int res = 0;
        Node node = null;
        for(int num : nums) {
            res += search(node, 2L * num + 1);
            node = insert(node, num);
        }
        return res;
    }

    private Node insert(Node node, int val) {
        if(node == null) {
            node = new Node(val);
        } else if (node.val == val) {
            node.cnt++;
        } else if(node.val < val) {
            node.cnt++;
            node.right = insert(node.right, val);
        } else {
            node.left = insert(node.left, val);
        }
        return node;
    }

    private int search(Node node, long val) {
        if(node == null) {
            return 0;
        } else if(node.val == val) {
            return node.cnt;
        } else if (node.val < val) {
            return search(node.right, val);
        } else {
            return node.cnt + search(node.left, val);
        }
    }

    class Node {
        int val, cnt;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            this.cnt = 1;
        }
    }
}
