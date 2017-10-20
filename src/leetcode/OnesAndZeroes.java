package leetcode;


public class OnesAndZeroes {

	/*public int findMaxForm(String[] strs, int m, int n) {
        int zeroes = 0, ones = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(String s : strs) {
        	zeroes = ones = 0;
            for(char c : s.toCharArray()) {
                if(c == '0') {
                	zeroes++;
                } else {
                    ones++;
                }
            }
            for(int i = m; i >= zeroes; i--) {
            	for(int j = n; j >= ones; j--) {
            		dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeroes][j - ones]);
            	}
            }
        }
        
        return dp[m][n];
    }*/
	
	public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zeroes = new int[len + 1], ones = new int[len + 1];
        for(int i = 1; i <= len; i++) {
            for(char c : strs[i - 1].toCharArray()) {
                if(c == '0') {
                	zeroes[i]++;
                } else {
                    ones[i]++;
                }
            }
        }
        int[][][] dp = new int[len][m + 1][n + 1];
        for(int i =  0; i <= m; i++){
            for(int j = 0; j <= n;j++){
                dp[0][i][j] = 1;
            }
        } 
        for(int k = 1; k < len; k++) {
        	for(int i = 0; i <= m; i++){
                for(int j = 0; j <= n;j++){
                    dp[k][i][j] = dp[k - 1][i][j];
                }
            } 
	        for(int i = zeroes[k]; i <= m; i++) {
	        	for(int j = ones[k]; j <= n; j++) {
    				dp[k][i][j] = Math.max(dp[k - 1][i][j], 
    						1 + dp[k - 1][i - zeroes[k]][j - ones[k]]);
	             }
	         }
        }
        return dp[len - 1][m][n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"10","0001","111001","1","0"};
		int m = 5, n = 3;
		OnesAndZeroes oaz = new OnesAndZeroes();
		System.out.println(oaz.findMaxForm(strs, m, n));
	}

}
