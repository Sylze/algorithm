package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int i = 0, j = 0, maxi, maxj;
		if(matrix.length % 2 == 0) {
			maxi = matrix.length / 2 - 1;
		} else {
			maxi = matrix.length / 2;
		}
		if(matrix[0].length % 2 == 0) {
			maxj = matrix[0].length / 2 - 1;
		} else {
			maxj = matrix[0].length / 2;
		}
		while (i <= maxi && j <= maxj) {
			oneSpiral(result, matrix, i, j);
			i++;
			j++;
		}
		return result;
	}

	private void oneSpiral(List<Integer> result, int[][] matrix, int i, int j) {
		int m = i, n = j;
		while (n < matrix[0].length - j) {
			result.add(matrix[m][n]);
			n++;
		}
		n--;
		m++;
		while (m < matrix.length - i) {
			result.add(matrix[m][n]);
			m++;
		}
		m--;
		if (m > i && n > j) {
			n--;
			while (n > j) {
				result.add(matrix[m][n]);
				n--;
			}
			while (m > i) {
				result.add(matrix[m][n]);
				m--;
			}
		}
	}

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
//		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//		int[][] matrix = {{3}, {2}};
		int[][] matrix = {};
		System.out.println(sm.spiralOrder(matrix));
	}

}
