class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        
        int mod = 1e9 + 7;
        int m = group.size();
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(minProfit + 1, vector<int>(m + 1, 0)));
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= minProfit; j++) {
                for (int k = 1; k <= m; k++) {
                    dp[i][j][k] = dp[i][j][k - 1];
                    if (i >= group[k - 1]) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - group[k - 1]][max(0, j - profit[k - 1])][k - 1]) % mod;
                    }
                }
            }
        }
        return dp[n][minProfit][m];
    }
};