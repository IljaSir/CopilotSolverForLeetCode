class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        
        vector<vector<string>> result;
        vector<string> temp(n, string(n, '.'));
        solveNQueens(result, temp, n, 0);
        return result;
    }
    void solveNQueens(vector<vector<string>> &result, vector<string> &temp, int n, int row) {
        if (row == n) {
            result.push_back(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(temp, row, col, n)) {
                temp[row][col] = 'Q';
                solveNQueens(result, temp, n, row + 1);
                temp[row][col] = '.';
            }
        }
    }
    bool isValid(vector<string> &temp, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (temp[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (temp[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (temp[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
};