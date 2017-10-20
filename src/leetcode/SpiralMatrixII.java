package leetcode;

public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		return generateMatrix(n, n);
    }
	
	public int[][] generateMatrix(int n, int m) {
		int[][] matrix = new int[n][m];
        int x = 0,
        y = Math.min(m, n) - 1,
        num = 1,
        xend = n - 1,
        yend = m - 1;
        while(x <= y) {
        	num = generateLayerMatrix(matrix, num, x, x, xend, yend);
        	x++;
        	xend--;
        	yend--;
        }
        return matrix;
	}
	
	private int generateLayerMatrix(int[][] matrix, int num, int xstart, int ystart, int xend, int yend) {
		if(xstart == xend && ystart == yend) {
			matrix[xstart][xend] = num++; 
			return num;
		}
		for(int i = ystart; i < yend; i++) {
			matrix[xstart][i] = num++;
		}
		for(int i = xstart; i < xend; i++) {
			matrix[i][yend] = num++; 
		}
		for(int i = yend; i > ystart; i--) {
			matrix[xend][i] = num++; 
		}
		for(int i = xend; i > xstart; i--) {
			matrix[i][ystart] = num++; 
		}
		return num;
	}
	
	public static void main(String[] args) {
		SpiralMatrixII sm2 = new SpiralMatrixII();
		for (int[] nums : sm2.generateMatrix(6, 8)) {
			for (int i : nums) {
				System.out.print(i);
				System.out.print("  ");
			}
			System.out.println();
		}
	}

}
