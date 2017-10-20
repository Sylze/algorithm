package leetcode;

public class CreateMaximumNumber {

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        findMax(nums1, nums2, res, 0, 0, k);
        return res;
    }
    
    private void findMax(int[] nums1, int[] nums2, int[] res, int i, int j, int k) {
        if(k > 0) {
            if(i == nums1.length) {
                int maxj = j;
                while(k > 0) {
	                for(int n = j; n <= nums2.length - k; n++) {
	                	if(nums2[n] > nums2[maxj]) maxj = n;
	                }
	                res[res.length - k] = Math.max(res[res.length - k], nums2[maxj]);
	                j = ++maxj;
	                k--;
                }
            } else if(j == nums2.length) {
            	int maxi = i;
            	while(k > 0) {
	                for(int m = i; m <= nums1.length - k; m++) {
	                	if(nums1[m] > nums1[maxi]) maxi = m;
	                }
	                res[res.length - k] = Math.max(res[res.length - k], nums1[maxi]);
	                i = ++maxi;
	                k--;
            	}
            } else {
                int maxi = i, maxj = j;
                for(int m = i; m <= Math.min(nums1.length - 1, nums1.length - i + nums2.length - j - k); m++) {
                    if(nums1[m] > nums1[maxi]) maxi = m;
                }
                for(int n = j; n <= Math.min(nums2.length - 1, nums2.length - j + nums1.length - i - k); n++) {
                    if(nums2[n] > nums2[maxj]) maxj = n;
                }
                if(nums1[maxi] > nums2[maxj]) {
                    res[res.length - k] = Math.max(res[res.length - k], nums1[maxi]);
                    findMax(nums1, nums2, res, maxi + 1, j, k - 1);
                } else if(nums1[maxi] < nums2[maxj]) {
                    res[res.length - k] = Math.max(res[res.length - k], nums2[maxj]);
                    findMax(nums1, nums2, res, i, maxj + 1, k - 1);
                } else {
                    res[res.length - k] = Math.max(res[res.length - k], nums1[maxi]);
                    findMax(nums1, nums2, res, maxi + 1, j, k - 1);
                    findMax(nums1, nums2, res, i, maxj + 1, k - 1);
                }
            }
        }
    }
	
	public static void main(String[] args) {
		CreateMaximumNumber cmn = new CreateMaximumNumber();
		for(int i: cmn.maxNumber(new int[]{1,2}, new int[]{}, 2))
			System.out.print(i + " ");
	}

}
