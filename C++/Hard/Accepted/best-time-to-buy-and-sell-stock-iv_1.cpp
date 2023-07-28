class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if (n < 2) return 0;
        if (k > n / 2) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += max(prices[i] - prices[i - 1], 0);
            }
            return res;
        }
        int dp[1001][2][101];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][0][j] = 0;
                    dp[i][1][j] = -prices[i];
                    continue;
                }
                dp[i][0][j] = max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }
        return dp[n - 1][0][k];
    }
};