class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i][j - 1] + time[j - 1][0] + time[j - 1][1] + time[j - 1][2] + time[j - 1][3];
                for (int l = 1; l <= j - 1; ++l) {
                    dp[i][j] = min(dp[i][j], max(dp[i][l], dp[0][j] + time[j - 1][0] + time[j - 1][1] + time[j - 1][2] + time[j - 1][3]));
                }
                for (int l = 1; l <= j - 1; ++l) {
                    dp[i][j] = min(dp[i][j], max(dp[i - 1][l], dp[0][j] + time[j - 1][0] + time[j - 1][1] + time[j - 1][2]));
                }
            }
        }
        return dp[n][k];
    }
};