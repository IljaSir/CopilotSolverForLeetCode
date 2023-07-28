class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        
        vector<vector<int>> dp(n + 1, vector<int>(minProfit + 1, 0));
        dp[0][0] = 1;
        int res = 0, mod = 1e9 + 7;
        for (int k = 0; k < group.size(); ++k) {
            int g = group[k], p = profit[k];
            for (int i = n; i >= g; --i) {
                for (int j = minProfit; j >= 0; --j) {
                    dp[i][j] = (dp[i][j] + dp[i - g][max(0, j - p)]) % mod;
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            res = (res + dp[i][minProfit]) % mod;
        }
        return res;
    }
};