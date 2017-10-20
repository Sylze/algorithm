package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
	
	private List<List<Integer>> result;
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		findSum(candidates, target, 0, 0, list);
		return result;
	}
	
	private void findSum(int[] candidates, int target, int index, int sum, List<Integer> list) {
		if(sum == target){
			List<Integer> temp = new ArrayList<Integer>();
			for(Integer i : list) {
				temp.add(i);
			}
			result.add(temp);
		} else if(sum < target){
			for(int i = index; i < candidates.length; i++) {
				if(candidates[i] + sum <= target) {
					list.add(candidates[i]);
					findSum(candidates, target, i, sum + candidates[i], list);
					list.remove(list.size() - 1);
				} else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		cs.combinationSum(candidates, target);
		for(List<Integer> list : cs.result) {
			System.out.println(list.hashCode());
		}
	}	
}
