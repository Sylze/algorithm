package leetcode;

import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {
	
	private final String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		result.add("");
		for(char c : digits.toCharArray()) {
			String letter = nums[Integer.valueOf(c)];
			if(letter.length() < 1) {
				continue;
			}
			List<String> temp = new ArrayList<String>();
			for(char cc : letter.toCharArray()) {
				for(String s : result) {
					temp.add(s + cc);
				}
			}
			result = temp; 
		}
		return result;
    }
	
	public static void main(String[] args) {
		
	}

}
