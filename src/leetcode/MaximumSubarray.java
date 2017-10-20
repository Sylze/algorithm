package leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		int[] nums = {-3,-2,0,-1};
		System.out.println(ms.maxSubArray(nums));
	}

}
