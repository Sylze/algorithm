package leetcode;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
		int n = A.length;
        if(n < 2) return n;
        int id = 1;
        for(int i = 1; i < n; ++i) 
            if(A[i] != A[i-1]) A[id++] = A[i];
        for(int i = 0; i < A.length; i++) {
        	System.out.println(A[i]);
        }
        return id;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray remove =new RemoveDuplicatesFromSortedArray();
		System.out.println(remove.removeDuplicates(new int[]{1,1,2,1}));
	}

}
