package leetcode;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		if(m < n) return uniquePaths(n, m);
        int[] result = new int[n + 1]; 
        for(int j = n -1; j >= 0; j--) {
        	result[j] = 1;
        }
        for(int i = m - 2; i >=0; i--) {
        	for(int j = n -1; j >= 0; j--) {
        		result[j] = result[j] + result[j+1];
        	}
        }
        return result[0];
    }
	
	//递归x,y从1开始计算
    private int findPath(int x, int y, int m, int n) {
        if(x == m) {
            return 1;
        }else if(y == n) {
        	return 1;
        }else {
            return findPath(x, y+1, m, n) + findPath(x+1, y, m, n);
        }
    }
	
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(23, 12));
	}

}
