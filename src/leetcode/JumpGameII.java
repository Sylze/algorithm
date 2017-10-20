package leetcode;

public class JumpGameII {

	public int jump(int[] nums) {
		return oneStep(0, nums);
	}

	private int oneStep(int index, int[] nums) {
		int step = nums[index];
		if (step >= nums.length - 1 - index) {
			return 1;
		}
		if (step == 1) {
			return 1 + oneStep(index + 1, nums);
		} else {
			int maxStep = 0;
			int maxSingleCount = 0;
			int singleCount = 0;
			for (; step > 0; step--) {
				singleCount = step + nums[index + step];
				if (singleCount > maxSingleCount) {
					maxSingleCount = singleCount;
					maxStep = step;
				}
			}
			return 1 + oneStep(index + maxStep, nums);
		}
	}
	
	/**
	 * 
	 * BFS
	 * public int jump(int[] Subsection) {
        int count = 0, max = 0;
        for (int i = 0, nextMax = 0; i <= max && i < Subsection.length - 1; i++) {
            nextMax = Math.max(nextMax, i + Subsection[i]);
            if (i == max) {
                max = nextMax;
                count++;
            }
        }
        // if there is no way to get to the end, return -1
        return max >= Subsection.length - 1 ? count : -1;
    }
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1 };
		JumpGameII jumpGame = new JumpGameII();
		System.out.println(jumpGame.jump(nums));
		System.out.println(nums.length);
	}

}
