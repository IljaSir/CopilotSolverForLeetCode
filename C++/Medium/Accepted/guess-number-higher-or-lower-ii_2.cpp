class Solution {
public:
    int getMoneyAmount(int n) {
        
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        for (int i = n - 1; i > 0; --i) {
            for (int j = i + 1; j <= n; ++j) {
                int global_min = INT_MAX;
                for (int k = i; k < j; ++k) {
                    int local_max = k + max(dp[i][k - 1], dp[k + 1][j]);
                    global_min = min(global_min, local_max);
                }
                dp[i][j] = global_min;
            }
        }
        return dp[1][n];
    }
};