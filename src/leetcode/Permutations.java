package leetcode;

import java.util.*;

public class Permutations {
	
	/*accepted other solution
	 * public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
		List<Integer> singleResult = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		List<List<Integer>> resultMap = new ArrayList<List<Integer>>();
		getResultUnique(nums, 0, visited, singleResult, resultMap);
		return resultMap;
	}

	private void getResultUnique(int[] nums, int index, boolean[] visited,
			List< Integer> singleResult,
			List<List<Integer>> resultMap) {
		if (index == nums.length) {
			resultMap.add(new ArrayList<Integer>(singleResult));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
			    if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
                    return;
                }
				visited[i] = true;
				singleResult.add(nums[i]);
				getResultUnique(nums, index + 1, visited, singleResult, resultMap);
				singleResult.remove(index);
				visited[i] = false;
			}
		}
	}
	 */
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> singleResult = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		Map<Integer, List<Integer>> resultMap = new Hashtable<Integer, List<Integer>>();
		getResultUnique(nums, visited, singleResult, resultMap);
		return new ArrayList<List<Integer>>(resultMap.values());
	}

	private void getResultUnique(int[] nums, boolean[] visited,
			List< Integer> singleResult,
			Map<Integer, List<Integer>> resultMap) {
		if (singleResult.size() == nums.length && !resultMap.containsKey(singleResult.hashCode())) {
			resultMap.put(singleResult.hashCode(), new ArrayList<Integer>(singleResult));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				singleResult.add(nums[i]);
				getResultUnique(nums, visited, singleResult, resultMap);
				singleResult.remove(singleResult.size() - 1);
				visited[i] = false;
			}
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> singleResult = new LinkedList<Integer>();
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		getResult(nums, singleResult, results);
		return results;
	}

	private void getResult(int[] nums, List<Integer> singleResult,
			List<List<Integer>> results) {
		if (singleResult.size() == nums.length) {
			results.add(new ArrayList<Integer>(singleResult));
		}
		for (int i = 0; i < nums.length; i++) {
			if (!singleResult.contains(nums[i])) {
				singleResult.add(nums[i]);
				getResult(nums, singleResult, results);
				singleResult.remove(singleResult.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = {1,1,2};
		List<List<Integer>> permute = p.permuteUnique(nums);
		System.out.println(permute);
	}

}
