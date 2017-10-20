package leetcode;

/*
 * Implement regular expression matching with support for '.' and '*'.
 */
public class RegularExpressionMatching {
	
	public boolean isMatch(String s, String p) { 
		if(p.length() == 0 && s.length() == 0) {
			return true;
		} else if(p.length() == 0) {
			return false;
		} else if(s.length() == 0) {
			if(p.length() % 2 == 0) {
				for(int i = 1; i < p.length(); i += 2) {
					if(p.charAt(i) != '*') {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		}
		return match(s, p, 0, 0);
	}
	
	private boolean match(String s, String p, int s_pos, int p_pos) {
		char s_char;
		if(p_pos == p.length() && s_pos == s.length()) return true;
		if(p_pos < p.length()) {
			if(s_pos > s.length() - 1){
				s_char = '\0';
			} else {
				s_char = s.charAt(s_pos);
			}
			if(p_pos < p.length() - 1) {
				if(p.charAt(p_pos + 1) == '*') return matchs(s, p, s_pos, p_pos + 2, p.charAt(p_pos));
			} else {
				if(p.charAt(p_pos) == '*') return matchs(s, p, s_pos, p_pos + 1, p.charAt(p_pos - 1));
			}
			if(p.charAt(p_pos) == s_char) return match(s, p, s_pos + 1, p_pos + 1);
			if(p.charAt(p_pos) == '.') return match(s, p, s_pos + 1, p_pos + 1);
		}
		return false;
	}

	private boolean matchs(String s, String p, int s_pos, int p_pos, char c) {
		do {
			if(match(s, p, s_pos, p_pos)) return true;
		} while(s_pos < s.length() && (s.charAt(s_pos++) == c || c == '.'));
		return false;
	}

	public static void main(String[] args) {
		RegularExpressionMatching matching = new RegularExpressionMatching();

		System.out.println(matching.isMatch("aa","a")); // false
		System.out.println(matching.isMatch("aa","aa")); // true
		System.out.println(matching.isMatch("aaa","aa")); // false
		System.out.println(matching.isMatch("aa", "a*")); // true
		System.out.println(matching.isMatch("aa", ".*")); // true
		System.out.println(matching.isMatch("ab", ".*")); // true
		System.out.println(matching.isMatch("aab", "c*a*b")); // true
		System.out.println(matching.isMatch("aaa","aaaa")); // false
		System.out.println(matching.isMatch("a","ab*")); // true
		System.out.println(matching.isMatch("ab",".*c")); // false
		System.out.println(matching.isMatch("a","")); // false
		
	}
}
