package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
	            if(dp[i] && set.contains(s.substring(i, j))) {
	                dp[j] = true;
	            }
            }
            if(dp[len]) break;
        }
        /**
         * faster way
         * for(int i = 1; i <= len; i++) {
            for(int j = i - 1; j >= 0; j--) {
	            if(dp[j] && set.contains(s.substring(j, i))) {
	                dp[i] = true;
	                break;
	            }
            }
        }
         */
        return dp[len];
    }

	public static void main(String[] args) {
		String s = "aaaaaaa";
		List<String> list =	Arrays.asList("aaaa", "aaa");
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak(s, list));
	}

}
