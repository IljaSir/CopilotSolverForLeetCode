class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        
        int n = jobDifficulty.size();
        if (n < d) return -1;
        vector<vector<int>> dp(d, vector<int>(n, INT_MAX));
        dp[0][0] = jobDifficulty[0];
        for (int j = 1; j < n; ++j) {
            dp[0][j] = max(dp[0][j-1], jobDifficulty[j]);
        }
        for (int i = 1; i < d; ++i) {
            for (int j = i; j < n; ++j) {
                int maxd = jobDifficulty[j];
                for (int k = j; k >= i; --k) {
                    maxd = max(maxd, jobDifficulty[k]);
                    dp[i][j] = min(dp[i][j], dp[i-1][k-1] + maxd);
                }
            }
        }
        return dp[d-1][n-1];
    }
};