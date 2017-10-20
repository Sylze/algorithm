package leetcode;

public class MedianOfTwoSortedArrays {
	    public double findMedianSortedArrays(int A[], int B[]) {
	        
	    	if(A.length == 0 && B.length == 0) {
	            return 0;
	        }

	        if(A.length == 0) {
	            if(B.length % 2 == 0) {
	                return (double)(B[B.length / 2] + B[B.length / 2 - 1])/2;
	            } else {
	                return (double)B[B.length / 2];
	            }
	        }
	        
	        if(B.length == 0) {
	            if(A.length % 2 == 0) {
	                return (double)(A[A.length / 2] + A[A.length / 2 - 1])/2;
	            } else {
	                return (double)A[A.length / 2];
	            }
	        }
	        
	        int length = A.length + B.length;
	        int [] result = new int[length];
	        int leftEnd = A.length - 1;
	        int rightEnd = B.length - 1;
	        int resultEnd = length / 2;
	        int leftPos = 0;
	        int rightPos = 0;
	        int resultPos = 0;
	        while(leftPos <= leftEnd && rightPos <= rightEnd) {
	            if(A[leftPos] <= B[rightPos]) {
	                result[resultPos++] = A[leftPos++];
	            } else {
	                result[resultPos++] = B[rightPos++];
	            }
	            
	            if(resultPos > resultEnd) {
	                break;
	            }
	        }
	        
	        while(leftPos <= Math.min(resultEnd, leftEnd) && resultPos <= resultEnd) {
	            result[resultPos++] = A[leftPos++];
	        }
	        
	        while(rightPos <= Math.min(resultEnd, rightEnd) && resultPos <= resultEnd) {
	            result[resultPos++] = B[rightPos++];
	        }
	        
	        if(length % 2 == 0) {
	            return (double)(result[resultEnd - 1] + result[resultEnd])/2;
	        }
	        return (double)result[resultEnd];
	    }
	
	public static void main(String[] args) {
		MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
		int[] a = {};
		int[] b = {2, 4, 6, 8};
		int[] c = {2, 4, 6};
		System.out.println(a.length);
		System.out.println(motsa.findMedianSortedArrays(a, b));
		System.out.println(motsa.findMedianSortedArrays(a, c));
	}

}
