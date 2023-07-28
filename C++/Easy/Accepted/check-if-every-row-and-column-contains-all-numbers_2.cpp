class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        for (int i = 0; i < n; ++i) {
            vector<int> row(n, 0);
            vector<int> col(n, 0);
            for (int j = 0; j < n; ++j) {
                row[matrix[i][j] - 1] = 1;
                col[matrix[j][i] - 1] = 1;
            }
            for (int j = 0; j < n; ++j) {
                if (row[j] == 0 || col[j] == 0) {
                    return false;
                }
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