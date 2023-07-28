class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = matrix[i-1][j];
                if (j > 0 && matrix[i-1][j-1] < min) {
                    min = matrix[i-1][j-1];
                }
                if (j < n - 1 && matrix[i-1][j+1] < min) {
                    min = matrix[i-1][j+1];
                }
                matrix[i][j] += min;
            }
        }
        int min = matrix[n-1][0];
        for (int j = 1; j < n; j++) {
            if (matrix[n-1][j] < min) {
                min = matrix[n-1][j];
            }
        }
        return min;
    }
};