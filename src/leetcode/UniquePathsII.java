package leetcode;

public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else if (i == 0) {
					if(j > 0){
						obstacleGrid[i][j] = obstacleGrid[i][j - 1];
					} else {//¥¶¿Ìµ„[0,0]
						obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? 1 : 0;
					}
				} else if (j == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				} else {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j]
							+ obstacleGrid[i][j - 1];
				}
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	public static void main(String[] args) {
		UniquePathsII bp2 = new UniquePathsII();
		System.out.println(bp2.uniquePathsWithObstacles(new int[][] {
				{ 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
	}

}
