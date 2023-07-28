class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        
        int n = jobDifficulty.size();
        if (n < d) {
            return -1;
        }
        vector<vector<int>> dp(n, vector<int>(d + 1, 1e9));
        dp[0][1] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = max(dp[i - 1][1], jobDifficulty[i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= min(i + 1, d); j++) {
                int maxDiff = 0;
                for (int k = i; k >= 0; k--) {
                    maxDiff = max(maxDiff, jobDifficulty[k]);
                    dp[i][j] = min(dp[i][j], dp[k - 1][j - 1] + maxDiff);
                }
            }
        }
        return dp[n - 1][d];
    }
};