class Solution {
public:
    void solve(vector<vector<char>>& board) {
        
        int m = board.size();
        if (m == 0) return;
        int n = board[0].size();
        if (n == 0) return;
        // 从边缘的O开始，向内部扩散
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        // 将O变为X，将#变为O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
};