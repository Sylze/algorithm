package leetcode;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s
					.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(Character.toUpperCase('0'));
		System.out.println(vp.isPalindrome("0P"));
	}

}
