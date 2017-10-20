package leetcode;


public class LongstSubstring {
	/*public int lengthOfLongestSubstring(String s) {
		
		if(s == null || s.equals("")) return 0;
		
		Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
		Character c ;
		int maxLength = 0;
		int startIndex = 0;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(hash.containsKey(c)) {
			    startIndex = Math.max((hash.get(c) + 1), startIndex);
			}
			hash.put(c, Integer.valueOf(i));
			maxLength = Math.max(i - startIndex + 1, maxLength);
		}
		return maxLength;
	}*/
	
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.equals("")) return 0;
		
		StringBuffer sb = new StringBuffer();
		Character c;
		int maxLength = 0;
		int temp = 0;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			temp = sb.indexOf(c.toString());
			if(temp >= 0) {
				maxLength = maxLength > sb.length() ? maxLength : sb.length();
				sb.delete(0, temp + 1);
			}
			sb.append(c);
		}
		
		return maxLength > sb.length() ? maxLength : sb.length();
	}
	
	public static void main(String[] args) {
		LongstSubstring ls = new LongstSubstring();
		String test1 = "jbpnbwwd";
		String test2 = "tmmzuxt";
		String test3 = "dvdf";
		System.out.println(ls.lengthOfLongestSubstring(test1));
		System.out.println(ls.lengthOfLongestSubstring(test2));
		System.out.println(ls.lengthOfLongestSubstring(test3));
	}
}
