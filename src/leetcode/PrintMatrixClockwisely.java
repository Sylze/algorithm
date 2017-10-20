package leetcode;

/**
 * Created by SZ on 2017/9/16.
 */
public class PrintMatrixClockwisely {
    public void printMatrixClockwisely(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int len = matrix.length, x = len - 1, y = 0;
        while (len > y * 2) {
            printMatrixInCircle(matrix, x, y);
            y++;
            x--;
        }
    }

    private void printMatrixInCircle(int[][] matrix, int x, int y) {
        int len = matrix.length, endY = len - y - 1, endX = len - x - 1;
        //从上到下
        for (int i = y; i <= endY; i++) {
            System.out.print(matrix[x][i]);
            System.out.print(" ");
        }

        //从右到左
        for (int i = x - 1; i >=endX ; i--) {
            System.out.print(matrix[i][endY]);
            System.out.print(" ");
        }

        //从下到上
        for (int i = endY - 1; i >= y ; i--  ) {
            System.out.print(matrix[endX][i]);
            System.out.print(" ");
        }

        //从左到右
        for (int i = endX + 1; i < x ; i++) {
            System.out.print(matrix[i][y]);
            if(i < x - 1) System.out.print(" ");
        }
    }
}
