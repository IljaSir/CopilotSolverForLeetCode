class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        int n = stockPrices.size();
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (stockPrices[i][1] >= stockPrices[j][1]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};