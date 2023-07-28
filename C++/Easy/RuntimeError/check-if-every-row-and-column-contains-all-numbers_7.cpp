class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int m = matrix[0].size();
        vector<int> row(n, 0);
        vector<int> col(m, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i] |= 1 << matrix[i][j];
                col[j] |= 1 << matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] != (1 << n + 1) - 2 || col[j] != (1 << n + 1) - 2) {
                    return false;
                }
            }
        }
        return true;
    }
};