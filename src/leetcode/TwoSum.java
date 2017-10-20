package leetcode;

import leetcode.BinaryTreeTraversal;

import java.util.Hashtable;




public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2]; 
		
		Hashtable<Integer, Integer> ht = new Hashtable<>(target);
		
		for(int i = 0; i < numbers.length;i++){
			
			Integer diff = Integer.valueOf((target - numbers[i]));
			if(ht.containsKey(diff)){
				result[0] = ht.get(diff) + 1;
				result[1] = i + 1; 
				return result;
			}
			
			ht.put(numbers[i], i);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		int [] numbers = {10, 7, 11, 15, 2};
		int target = 9;
		TwoSum twoSum = new TwoSum();
		int[] a = twoSum.twoSum(numbers, target);
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
}
