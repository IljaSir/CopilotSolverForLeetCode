class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        int n = stockPrices.size(), res = 0;
        vector<int> dp(n, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (stockPrices[j][1] <= stockPrices[i][1]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};