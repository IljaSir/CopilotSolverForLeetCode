class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> row(m, 0);
        vector<int> col(n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = max(row[i], matrix[i][j]);
                col[j] = min(col[j], matrix[i][j]);
            }
        }
        vector<int> res;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) {
                    res.push_back(matrix[i][j]);
                }
            }
        }
        return res;
    }
};