class Solution {
public:
    int tallestBillboard(vector<int>& rods) {
        
        int n = rods.size();
        int sum = accumulate(rods.begin(), rods.end(), 0);
        vector<vector<int>> dp(n+1, vector<int>(sum+1, -1));
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                if (dp[i][j] == -1) continue;
                dp[i+1][j] = max(dp[i+1][j], dp[i][j]);
                dp[i+1][j+rods[i]] = max(dp[i+1][j+rods[i]], dp[i][j]);
                dp[i+1][abs(j-rods[i])] = max(dp[i+1][abs(j-rods[i])], dp[i][j] + min(j, rods[i]));
            }
        }
        return dp[n][0];
    }
};