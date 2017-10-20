package leetcode;

public class FindFirstMissingNumber {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 1;
		int k = partition(nums) + 1;
		int temp = 0;
		int first_missing_Index = k;
		for (int i = 0; i < k; i++) {
			temp = Math.abs(nums[i]);
			if (temp <= k)
				nums[temp - 1] = (nums[temp - 1] < 0) ? nums[temp - 1]
						: -nums[temp - 1];
		}
		for (int i = 0; i < k; i++) {
			if (nums[i] > 0) {
				first_missing_Index = i;
				break;
			}
		}
		return first_missing_Index + 1;
	}

	public int partition(int[] A) {
		int n = A.length;
		int q = -1;
		for (int i = 0; i < n; i++) {
			if (A[i] > 0) {
				A[++q] = A[i];
			}
		}
		return q;
	}

	public void swap(int[] A, int i, int j) {
		if (i != j) {
			A[i] ^= A[j];
			A[j] ^= A[i];
			A[i] ^= A[j];
		}
	}
	
	public static void main(String[] args) {
		FindFirstMissingNumber f = new FindFirstMissingNumber();
		int[] nums = {3, 1, -1, 4};
		System.out.println(f.firstMissingPositive(nums));
	}
}
