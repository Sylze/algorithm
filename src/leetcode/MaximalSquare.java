package leetcode;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int w = matrix[0].length, res = 0, square = 0, min = 0;
        int[] width = new int[w + 1], height = new int[w + 1];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 1; j <= w; j++) {
                if(matrix[i][j - 1] == '1') {
                    height[j] = height[j] + 1;
                    width[j] = width[j - 1] + 1;
                    square = min = Math.min(Math.min(i + 1, height[j]), width[j]);
                    for(int k = 0; k < min; k++) {
                        square = Math.min(square, height[j - k]);
                        square = Math.min(k + 1, square);
                        res = Math.max(res, square * square);
                    }
                    
                } else {
                    width[j] = 0;
                    height[j] = 0;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		char[][] matrix = {
				"01101".toCharArray(),
				"11010".toCharArray(),
				"01110".toCharArray(),
				"11110".toCharArray(),
				"11111".toCharArray(),
				"00000".toCharArray()
		};
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}

}
