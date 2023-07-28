class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        
        vector<vector<string>> res;
        vector<int> row(n, -1);
        dfs(n, 0, row, res);
        return res;
    }
    
    void dfs(int n, int cur, vector<int>& row, vector<vector<string>>& res) {
        if (cur == n) {
            vector<string> board(n, string(n, '.'));
            for (int i = 0; i < n; ++i) {
                board[i][row[i]] = 'Q';
            }
            res.push_back(board);
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (isValid(cur, i, row)) {
                row[cur] = i;
                dfs(n, cur + 1, row, res);
                row[cur] = -1;
            }
        }
    }
    
    bool isValid(int x, int y, vector<int>& row) {
        for (int i = 0; i < x; ++i) {
            if (y == row[i] || abs(x - i) == abs(y - row[i])) {
                return false;
            }
        }
        return true;
    }
};