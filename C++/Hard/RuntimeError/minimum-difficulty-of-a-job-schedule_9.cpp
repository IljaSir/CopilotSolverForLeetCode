class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        
        int n = jobDifficulty.size();
        if (n < d) return -1;
        vector<vector<int>> dp(n, vector<int>(d, 0));
        int maxv = jobDifficulty[0];
        for (int i = 0; i < d; i++) {
            maxv = max(maxv, jobDifficulty[i]);
            dp[i][i] = maxv;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < min(i, d-1); j++) {
                int maxv = jobDifficulty[i];
                for (int k = i-1; k >= j; k--) {
                    maxv = max(maxv, jobDifficulty[k]);
                    dp[i][j] = max(dp[i][j], dp[k-1][j-1] + maxv);
                }
            }
        }
        return dp[n-1][d-1];
    }
};