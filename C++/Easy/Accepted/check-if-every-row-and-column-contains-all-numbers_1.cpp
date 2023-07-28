class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        vector<bool> row(n, false);
        vector<bool> col(n, false);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] > n) {
                    return false;
                }
                row[matrix[i][j] - 1] = true;
                col[matrix[j][i] - 1] = true;
            }
            for (int j = 0; j < n; ++j) {
                if (!row[j] || !col[j]) {
                    return false;
                }
                row[j] = false;
                col[j] = false;
            }
        }
        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<vector<int>> matrix(9, vector<int>(9, 0));
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    matrix[i][j] = board[i][j] - '0';
                }
            }
        }
        return checkValid(matrix);
    }
};