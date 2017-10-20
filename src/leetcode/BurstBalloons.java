package leetcode;

public class BurstBalloons {

	public int maxCoins(int[] nums) {
        boolean[] marks = new boolean[nums.length];
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += getMaxCoin(nums, marks);
        }
        return res;
    }
    
    private int getMaxCoin(int[] nums, boolean[] marks) {
        int maxCoin = 0,maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            int left = 1, right = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(!marks[j]) {
                    left = nums[j];
                    break;
                }
            }
            for(int j = i + 1; j < nums.length; j++) {
                if(!marks[j]) {
                    right = nums[j];
                    break;
                }
            }
            int coin = left * nums[i] * right;
            if(coin > maxCoin) {
                maxCoin = coin;
                maxIndex = i;
            }
        }
        marks[maxIndex] = true;
        return maxCoin;
    }
	
	public static void main(String[] args) {
		BurstBalloons bb = new BurstBalloons();
		System.out.println(bb.maxCoins(new int[]{3,1,5,8}));
	}

}
