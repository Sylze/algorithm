package leetcode;

public class PerfectSquares {

	public int numSquares(int n) {
        int[] nums = new int[n + 1];
        int sqrt = 1;
        for(int i = 1; i < nums.length; i++) {
            sqrt = (int)Math.sqrt(i);
            if(i == sqrt*sqrt) {
                nums[i] = 1;
            } else {
                int num = Integer.MAX_VALUE;
                for(int j = sqrt; j > 0; j--) {
                    num = Math.min(num, nums[j*j] + nums[i - j*j]);
                }
                nums[i] = num;
            }
        }
        return nums[n];
    }
	
	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares(3));
	}

}
