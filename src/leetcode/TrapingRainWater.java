package leetcode;

public class TrapingRainWater {

	//计算差
	public int trap(int[] height) {
        if(height.length < 2) return 0;
        int left = 0,
            right = height.length - 1,
            h = 0,
            preh = 0,
            sum = 0,
            totsum = 0,
            preleft = -1,
            preright = -1;
        while(left <= right) {
            if(height[left] == 0 ) {
                left++;
                continue;
            } 
            if(height[right] == 0){
                right--;
                continue;
            }
            if(left == right) {
            	sum += ((preleft != left && preright != right) ? height[left] : 0);
            } else {
	            sum += (preleft != left ? height[left] : 0);
	            sum += (preright != right ? height[right] : 0);
            }
            h = height[left] > height[right] ? height[right] : height[left];
            if(h - preh > 0){
            	totsum += (h - preh) * (right - left + 1);
            }
            
            preleft = left;
            preright = right;
            
            if(height[left] == height[right] || Math.max(height[left], height[right]) <= preh) {
            	left++;
            	right--;
            } else {
            	if(height[left] > height[right]) {
            		right--; 
            	} else {
            		left++;
            	}
            }
            preh = h > preh ? h : preh;
        }
        return totsum - sum;
    }
	
	/*
	 * 更好的解法
	 public int trap(int[] height) {
        if(height.length < 2) return 0;
        int left=0; int right=height.length-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxleft) maxleft=height[left];
                else res+=maxleft-height[left];
                left++;
            }
            else{
                if(height[right]>=maxright) maxright= height[right];
                else res+=maxright-height[right];
                right--;
            }
        }
        return res;
    }
	 * */
	
	public static void main(String[] args) {
		TrapingRainWater trw = new TrapingRainWater();
		int[] nums1 = {4,2,3};
		int[] nums2 = {5,2,1,2,1,5};
		int[] nums3 = {5,4,1,2};
		int[] nums4 = {2,1,0,2};
		System.out.println(trw.trap(nums1));
		System.out.println(trw.trap(nums2));
		System.out.println(trw.trap(nums3));
		System.out.println(trw.trap(nums4));
	}

}
