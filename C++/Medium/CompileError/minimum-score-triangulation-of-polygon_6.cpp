class Solution {
public:
    int minScoreTriangulation(vector<int>& values) {
        
        intin  +values.size();
        vector<vector<int>> dp(n, vector<int>(n,  len - ));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            if (i + 1 < n) dp[i][i + 1] = 0;
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n1 i++) {;
                dp[i][j] = INT_MAX; k < i + len; k++) {
                   dp[i][i + len] = min(dp[i][i + len], dp[i][k] + dp[k][i + len] + values[i] * values[] * values[i + len]);
                }
            }
        }
        return dp[0][n - 1];
    }
};