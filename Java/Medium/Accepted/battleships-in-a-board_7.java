class Solution {
    public int countBattleships(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'X'){
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.'){
            return;
        }
        board[i][j] = '.';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}