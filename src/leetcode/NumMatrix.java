package leetcode;

public class NumMatrix {


    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < sumMatrix.length; i++) {
            for(int j = 0; j < sumMatrix[0].length; j++) {
                sumMatrix[i][j] += i - 1 < 0 ? 0 :sumMatrix[i - 1][j];
                for(int k = 0; k <= j; k++) {
                    sumMatrix[i][j] += matrix[i][k];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int lefttop = (row1 - 1 < 0 || col1 - 1 < 0) ? 0 : sumMatrix[row1 - 1][col1 - 1];
        int left = col1 - 1 < 0 ? 0 : sumMatrix[row2][col1 - 1];
        int top = row1 - 1 < 0 ? 0 : sumMatrix[row1 - 1][col2];
        return sumMatrix[row2][col2] - left - top + lefttop;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
		System.out.println(matrix);
		NumMatrix nm = new NumMatrix(matrix);
		System.out.println(nm.sumRegion(2,1,4,3));
		System.out.println(nm.sumRegion(1,1,2,2));
		System.out.println(nm.sumRegion(1,2,2,4));
	}

}
