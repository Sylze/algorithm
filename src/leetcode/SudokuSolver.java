package leetcode;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	solve(board, 0);
    	for(char[] chars : board) {
    		System.out.println(String.valueOf(chars));
    	}
    }
    
    private boolean solve(char[][] board, int pos) {
    	if(pos >= 81) return true;
    	int i = pos / 9;
        int j = pos % 9;
        if (board[i][j] != '.') {
            return solve(board, pos + 1);
        } else {
            for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9 for each cell
                if(isValidSudoku(board, i, j, c)){
                    board[i][j] = c; //Put c for this cell

                    if(solve(board, pos + 1))
                        return true; //If it's the solution return true
                    else
                        board[i][j] = '.'; //Otherwise go back
                }
            }
            return false;
        }
    }
    
    
    public boolean isValidSudoku(char[][] board, int i, int j, char c) {
    	 //Check colum
        for(int row = 0; row < 9; row++)
            if(board[row][j] == c)
                return false;

        //Check row
        for(int col = 0; col < 9; col++)
            if(board[i][col] == c)
                return false;

        //Check 3 x 3 block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }
    
    public static void main(String[] args) {
    	SudokuSolver ss = new SudokuSolver();
    	String[] str = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	char[][] board = new char[str.length][];
    	for(int i = 0; i < str.length; i++) {
    		board[i] = str[i].toCharArray();
    	}
    	ss.solveSudoku(board);   	
    }
}
