class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = matrix[i - 1][j];
                if (j > 0) v = min(v, matrix[i - 1][j - 1]);
                if (j < n - 1) v = min(v, matrix[i - 1][j + 1]);
                matrix[i][j] += v;
            }
        }
        return *min_element(matrix.back().begin(), matrix.back().end());
    }
};