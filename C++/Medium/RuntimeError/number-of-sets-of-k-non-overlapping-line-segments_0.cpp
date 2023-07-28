class Solution {
public:
    int numberOfSets(int n, int k) {
        
        vector<vector<int>> dp(n, vector<int>(k + 1, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % 1000000007;
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
                dp[i][j] = (dp[i][j] + dp[i - 2][j - 1]) % 1000000007;
            }
        }
        return dp[n - 1][k];
    }
};