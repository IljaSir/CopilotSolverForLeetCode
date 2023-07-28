class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        vector<int> r(n, 0);
        vector<int> c(n, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i] |= (1 << matrix[i][j]);
                c[j] |= (1 << matrix[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (r[i] != (1 << (n + 1)) - 2 || c[i] != (1 << (n + 1)) - 2) {
                return false;
            }
        }
        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        int n = board.size();
        vector<vector<int>> matrix(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = board[i][j] - '0';
                }
            }
        }
        return checkValid(matrix);
    }
};