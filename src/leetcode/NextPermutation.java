package leetcode;

import java.util.Arrays;


public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int pre = -1;
        int nextbigpre = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                pre = i;
                nextbigpre = i + 1;
            } else {
                if(pre >= 0 && nums[i + 1] > nums[pre]) nextbigpre = i + 1;
                continue;
            }
        }
        if(pre >= 0) {
            swap(nums, nextbigpre, pre);
            int i = pre + 1;
            int j = nums.length -1;
            while(i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        } else {
            Arrays.sort(nums);
        }
    }
	
	/*
	 * public void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        int i = nums.length - 2;
        for( ; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                break;
            } 
        }
        if(i >= 0) {
            while(nums[k] <= nums[i]) k--;
            swap(nums, k, i);
        }
        Arrays.sort(nums, i + 1, nums.length);
    }
	 */
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
		int[] input = new int[]{4,2,0,2,3,2,0};
		np.nextPermutation(input);
		for(int i : input) {
			System.out.print(i+",");
		}
	}

}
