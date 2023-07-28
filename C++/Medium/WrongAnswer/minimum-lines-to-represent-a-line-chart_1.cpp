class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        int n = stockPrices.size();
        vector<int> dp(n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (stockPrices[j][1] <= stockPrices[i][1]) {
                    dp[i] = std::max(dp[i], dp[j] + 1);
                }
            }
        }
        return *std::max_element(dp.begin(), dp.end());
    }
};