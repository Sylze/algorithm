package leetcode;

public class PalindromeNumber {

	 public boolean isPalindrome(int x) {
		   if(x<0){
	            return false;
	        }
	
	        long temp = x,reverse=0;
	        while(temp!=0){
	            reverse = 10*reverse+temp%10;
	            temp = temp/10;
	        }
	        return reverse==x;
		  
	 }
	
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(10));
//		Long a = new Long("11");
//		int b = 11;
//		System.out.println(a == b);
	}

}
