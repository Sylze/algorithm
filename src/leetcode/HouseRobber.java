
public class HouseRobber {
	
    
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++) {
        	nums[i] = Math.max((i - 2 < 0 ? 0 : nums[i - 2]) + nums[i], (i - 1 < 0 ? 0 : nums[i - 1]));
        }
        return nums[nums.length - 1];
    }
    

	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(new int[]{1,2,3,4,5,6,7,8,9}));
		System.out.println(hr.rob(new int[]{1,2,3,7,5,6,7,8,9}));
	}

}
