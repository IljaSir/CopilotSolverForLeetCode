class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int a = matrix[i-1][j];
                int b = j > 0 ? matrix[i-1][j-1] : INT_MAX;
                int c = j < n-1 ? matrix[i-1][j+1] : INT_MAX;
                matrix[i][j] += min(a, min(b, c));
            }
        }
        return *min_element(matrix.back().begin(), matrix.back().end());
    }
};