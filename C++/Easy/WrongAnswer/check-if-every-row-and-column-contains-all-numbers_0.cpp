class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > n || matrix[i][j] < 1) return false;
            }
        }
        return true;
    }
    bool isValidSudoku(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            vector<bool> row(n, false);
            vector<bool> col(n, false);
            for (int j = 0; j < n; j++) {
                if (row[matrix[i][j] - 1]) return false;
                if (col[matrix[j][i] - 1]) return false;
                row[matrix[i][j] - 1] = true;
                col[matrix[j][i] - 1] = true;
            }
        }
        return checkValid(matrix);
    }
};