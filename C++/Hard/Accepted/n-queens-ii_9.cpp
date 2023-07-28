class Solution {
public:
    int totalNQueens(int n) {
        
        int count = 0;
        vector<int> col(n, 0);
        vector<int> diag(2 * n, 0);
        vector<int> anti_diag(2 * n, 0);
        dfs(0, n, col, diag, anti_diag, count);
        return count;
    }
    
    void dfs(int row, int n, vector<int>& col, vector<int>& diag, vector<int>& anti_diag, int& count) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] == 0 && diag[row + i] == 0 && anti_diag[row - i + n] == 0) {
                col[i] = 1;
                diag[row + i] = 1;
                anti_diag[row - i + n] = 1;
                dfs(row + 1, n, col, diag, anti_diag, count);
                col[i] = 0;
                diag[row + i] = 0;
                anti_diag[row - i + n] = 0;
            }
        }
    }
};