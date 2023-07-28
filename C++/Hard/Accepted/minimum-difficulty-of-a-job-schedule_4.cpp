class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        
        int n = jobDifficulty.size();
        if (n < d) return -1;
        vector<vector<int>> dp(d, vector<int>(n, 0));
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; ++i) {
            dp[0][i] = max(dp[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; ++i) {
            for (int j = i; j < n; ++j) {
                int curMax = jobDifficulty[j];
                dp[i][j] = INT_MAX;
                for (int k = j; k >= i; --k) {
                    curMax = max(curMax, jobDifficulty[k]);
                    dp[i][j] = min(dp[i][j], dp[i - 1][k - 1] + curMax);
                }
            }
        }
        return dp[d - 1][n - 1];
    }
};