package leetcode;

public class PermutationInString {
	
	public boolean checkInclusion(String s, String p) {
//		List<Integer> res = new LinkedList<>();
        int sLen = s.length(), pLen = p.length();
        
        int[] count = new int[26];
        for (int i = 0; i < sLen; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']--;
            if(i - sLen >= 0) {
                count[p.charAt(i - sLen) - 'a']++;
            }
            if (allZero(count)) {
//                res.add(i);
            	return true;
            }
        }
        
        return false;
    }
    
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		PermutationInString pis = new PermutationInString();
		System.out.println(pis.checkInclusion("abc", "bbbca"));
//		System.out.println(pis.checkInclusion("ab", "ab"));
//		System.out.println(pis.checkInclusion("ab", "eidbaooo"));
//		System.out.println(pis.checkInclusion("hello", "ooolleoooleh"));
//		System.out.println(pis.checkInclusion("abc", "ccccbbbbaaaa"));
	}

}
