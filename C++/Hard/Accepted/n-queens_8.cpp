class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        
        vector<vector<string>> res;
        vector<int> col(n, 0);
        vector<int> diag(2*n, 0);
        vector<int> antiDiag(2*n, 0);
        vector<string> board(n, string(n, '.'));
        backtrack(res, board, 0, col, diag, antiDiag);
        return res;
    }
    
    void backtrack(vector<vector<string>>& res, vector<string>& board, int row, vector<int>& col, vector<int>& diag, vector<int>& antiDiag){
        int n = board.size();
        if(row == n){
            res.push_back(board);
            return;
        }
        for(int i = 0; i < n; i++){
            if(col[i] == 0 && diag[row+i] == 0 && antiDiag[row-i+n] == 0){
                col[i] = diag[row+i] = antiDiag[row-i+n] = 1;
                board[row][i] = 'Q';
                backtrack(res, board, row+1, col, diag, antiDiag);
                board[row][i] = '.';
                col[i] = diag[row+i] = antiDiag[row-i+n] = 0;
            }
        }
    }
};