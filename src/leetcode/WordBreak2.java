package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> res = new HashMap<>();
        return help(res, s, set);
    }
    
    private List<String> help(Map<String, List<String>> map, String s,  Set<String> set) {
        if(map.containsKey(s)) {
            return map.get(s);
        } 
        List<String> list = new LinkedList<>(), subList = null;
        String subStr = null;
        for(int j = 1; j <= s.length(); j++) {
        	subStr = s.substring(0, j);
        	if(set.contains(subStr)) {
        		if(j == s.length()) {
        			list.add(subStr);
        			break;
        		}
        		subList = help(map, s.substring(j), set);
        		for(String str : subList) {
        			list.add(subStr + " " + str);
        		}
        	}
        }
        map.put(s, list);
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak2 wb2 = new WordBreak2();
		String s = "aaaaaaa";
		List<String> list = Arrays.asList("aaaa","aa","a");
		List<String> wordBreak = wb2.wordBreak(s, list);
		for(String str : wordBreak) {
			System.out.println(str);
		}
	}

}
