class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board =new char[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }
        backtrack(0,board,n);
        return result; 
    }
    void backtrack(int row,char[][] board,int n)
    {
         if (row == n) 
         {
            result.add(makeBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) 
        {
            if (isSafe(board, row, col, n)) 
            {
                board[row][col] = 'Q';
                backtrack(row + 1, board, n);
                board[row][col] = '.'; 
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col, int n) 
    {
        for (int i = 0; i < row; i++) 
        {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
         {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) 
        {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    List<String> makeBoard(char[][] board) 
    {
        List<String> list = new ArrayList<>();
        for (char[] row : board) 
        {
            list.add(new String(row));
        }
        return list;
    }
}