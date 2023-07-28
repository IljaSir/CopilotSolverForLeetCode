class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        
        int n = board.size();
        if (n < 1) return;
        int m = board[0].size();
        if (m < 1) return;
        bool solved = false;
        solve(board, 0, 0, solved);
    }
};