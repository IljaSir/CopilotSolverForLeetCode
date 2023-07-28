class Solution {
public:
    int tallestBillboard(vector<int>& rods) {
        
        int n = rods.size();
        int sum = accumulate(rods.begin(), rods.end(), 0);
        vector<vector<int>> dp(n+1, vector<int>(sum+1, -1));
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            int w = rods[i-1];
            for (int j = 0; j <= sum; ++j) {
                if (dp[i-1][j] >= 0) {
                    dp[i][j] = max(dp[i][j], dp[i-1][j]);
                    dp[i][j+w] = max(dp[i][j+w], dp[i-1][j]);
                    dp[i][abs(j-w)] = max(dp[i][abs(j-w)], dp[i-1][j]+min(j, w));
                }
            }
        }
        return dp[n][0];
    }
};