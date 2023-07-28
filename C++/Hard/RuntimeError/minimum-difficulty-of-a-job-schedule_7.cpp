class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        
        int n = jobDifficulty.size();
        if (n < d) return -1;
        vector<vector<int>> dp(n + 1, vector<int>(d + 1, 0x7fffffff));
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            int maxd = 0;
            for (int j = i; j >= 1; --j) {
                maxd = max(maxd, jobDifficulty[j - 1]);
                for (int k = 1; k <= min(j, d); ++k) {
                    dp[i][k] = min(dp[i][k], dp[j - 1][k - 1] + maxd);
                }
            }
        }
        return dp[n][d];
    }
};