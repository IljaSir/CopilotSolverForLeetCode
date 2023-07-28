class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        
        for (int i = 0; i < n; ++i) {
            dp[n-1][i] = matrix[n-1][i];
        }
        
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                int left = j - 1 >= 0 ? dp[i+1][j-1] : INT_MAX;
                int right = j + 1 < n ? dp[i+1][j+1] : INT_MAX;
                dp[i][j] = min(dp[i+1][j], min(left, right)) + matrix[i][j];
            }
        }
        
        int result = INT_MAX;
        for (int i = 0; i < n; ++i) {
            result = min(result, dp[0][i]);
        }
        return result;
    }
};