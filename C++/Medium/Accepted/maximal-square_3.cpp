class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        
        int m = matrix.size();
        if (m == 0) return 0;
        int n = matrix[0].size();
        if (n == 0) return 0;
        int dp[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxLen = max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
};