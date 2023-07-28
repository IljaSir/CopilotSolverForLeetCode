class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        vector<int> result;
        int m = matrix.size();
        if (m == 0) {
            return result;
        }
        int n = matrix[0].size();
        if (n == 0) {
            return result;
        }
        int row = 0;
        int col = 0;
        while (row < m && col < n) {
            for (int i = col; i < n; ++i) {
                result.push_back(matrix[row][i]);
            }
            ++row;
            for (int i = row; i < m; ++i) {
                result.push_back(matrix[i][n - 1]);
            }
            --n;
            if (row < m) {
                for (int i = n - 1; i >= col; --i) {
                    result.push_back(matrix[m - 1][i]);
                }
                --m;
            }
            if (col < n) {
                for (int i = m - 1; i >= row; --i) {
                    result.push_back(matrix[i][col]);
                }
                ++col;
            }
        }
        return result;
    }
};