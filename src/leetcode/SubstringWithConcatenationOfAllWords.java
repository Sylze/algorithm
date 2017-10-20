package leetcode;

import leetcode.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		Hashtable<String, Integer> htwords = new Hashtable<String, Integer>();
		for(String word : words) {
			if(htwords.containsKey(word)) {
				htwords.put(word, htwords.get(word) + 1);
			} else {
				htwords.put(word, 1);
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		int wordlen = words[0].length();
		int wordslen = wordlen * words.length;
		Hashtable<String, Integer> loop = null;
		for(int i = 0; i <= s.length() - wordslen; i++) {
			loop = new Hashtable<String, Integer>();
			for(int j = i; j < i + wordslen; j += wordlen) {
				String temp = s.substring(j, j + wordlen);
				if(htwords.containsKey(temp)) {
					loop.put(temp, (!loop.containsKey(temp) ? 1 : loop.get(temp) + 1));
				} else {
					break;
				}
			}
			if(loop.equals(htwords)) {
				result.add(i);
			} 
		}
		return result;
	}

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		List<Integer> result = s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
		//List<Integer> result = s.findSubstring("aaa", new String[]{"a", "a"});
		System.out.println(result == null);
		System.out.println(result.size());
		for(Integer i : result) {
			System.out.println(i);
		}
	}

}
