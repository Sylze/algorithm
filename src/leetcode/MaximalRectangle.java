package leetcode;

import java.util.Arrays;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] width = new int[m + 1][n + 1];
		int max = 0;
		for(int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(matrix[i - 1][j - 1] == '0') {
					width[i][j] = 0;
				} else {
					width[i][j] = width[i][j - 1] + 1;
				}
			}
		}
		for(int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(width[i][j] == 0) {
					continue;
				}
				int h = 0, w = width[i][j];
				for(int k = i; k > 0; k--) {
					if(width[k][j] == 0) {
						break;
					}
					h++;
					w = Math.min(width[k][j], w);
					max = Math.max(w * h, max);
				}	
			}
		}
        return max;
    }
	
	public int maximalRectangleByDP(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int len = matrix[0].length;
		int[] h = new int[len];
		int[] left = new int[len];
		int[] right = new int[len];
		Arrays.fill(right, len);
		int res = 0;
		for(int i = 0; i < matrix.length; i++) {
			int cur_left = 0, cur_right = len;
			for(int j = 0; j < len; j++) {
				if(matrix[i][j] == '1') {
					h[j]++;
				} else {
					h[j] = 0;
				}
			}
			
			for(int j = 0; j < len; j++) {
				if(matrix[i][j] == '1') {
					left[j] = Math.max(left[j], cur_left);
				} else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			
			for(int j = len - 1; j >= 0; j--) {
				if(matrix[i][j] == '1') {
					right[j] = Math.min(right[j], cur_right);
				} else {
					right[j] = len;
					cur_right = j;
				}
			}
			
			for(int j = 0; j < len; j++) {
				res = Math.max(res, h[j] * (right[j] - left[j]));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		MaximalRectangle mr = new MaximalRectangle();
		char[][] matrix = {
//							{'1', '0', '1', '0', '0'},
//							{'1', '0', '1', '1', '1'},
//							{'1', '1', '1', '1', '1'},
//							{'1', '0', '0', '1', '0'}
				{'0', '1', '1', '0', '1'},
				{'1', '1', '0', '1', '0'},
				{'0', '1', '1', '1', '0'},
				{'1', '1', '1', '1', '0'},
				{'1', '1', '1', '1', '1'},
				{'0', '0', '0', '0', '0'}
						};
		System.out.println(mr.maximalRectangle(matrix));
		System.out.println(mr.maximalRectangleByDP(matrix));
	}

}
