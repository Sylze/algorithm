package leetcode;

import java.util.HashMap;
import java.util.Map;


public class WordPattern {
	
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.trim().split(" ");
        char c;
        if(strs.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
        	c = pattern.charAt(i);
        	if(!map.containsKey(c)) {
        		if(!map.containsValue(strs[i])) {
        			map.put(c, strs[i]);
        		} else {
        			return false;
        		}
        	} else {
        		if(!strs[i].equals(map.get(c))) {
        			return false;
        		}
        	}
        }
		return true;
    }

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog dog dog dog"));
		System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
	}

}
