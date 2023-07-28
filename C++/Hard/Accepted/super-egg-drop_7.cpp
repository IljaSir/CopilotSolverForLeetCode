class Solution {
public:
    int superEggDrop(int k, int n) {
        
        // dp[m][k] = n
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        // dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        vector<vector<int>> dp(n+1, vector<int>(k+1, 0));
        int m = 0;
        while (dp[m][k] < n) {
            ++m;
            for (int i = 1; i <= k; ++i) {
                dp[m][i] = dp[m-1][i-1] + dp[m-1][i] + 1;
            }
        }
        return m;
    }
};