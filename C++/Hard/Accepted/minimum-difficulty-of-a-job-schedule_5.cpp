class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        
        int n = jobDifficulty.size();
        if (n < d) return -1;
        vector<vector<int>> dp(n, vector<int>(d + 1, INT_MAX));
        dp[0][1] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = max(jobDifficulty[i], dp[i - 1][1]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= d && j <= i + 1; j++) {
                int maxd = jobDifficulty[i];
                for (int k = i; k >= j - 1; k--) {
                    maxd = max(maxd, jobDifficulty[k]);
                    if (dp[k - 1][j - 1] != INT_MAX) {
                        dp[i][j] = min(dp[i][j], dp[k - 1][j - 1] + maxd);
                    }
                }
            }
        }
        return dp[n - 1][d];
    }
};