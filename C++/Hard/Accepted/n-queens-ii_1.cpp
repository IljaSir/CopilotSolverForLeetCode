class Solution {
public:
    int totalNQueens(int n) {
        
        int res = 0;
        vector<int> queens(n, -1);
        dfs(queens, 0, res);
        return res;
    }
    
    void dfs(vector<int> &queens, int row, int &res) {
        int n = queens.size();
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                dfs(queens, row + 1, res);
                queens[row] = -1;
            }
        }
    }
    
    bool isValid(vector<int> &queens, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (queens[i] == col || abs(row - i) == abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }
};