class Solution {
public:
    int numberOfWays(int startPos, int endPos, int k) {
        
        vector<vector<int>> dp(k+1, vector<int>(1001, 0));
        dp[0][startPos] = 1;
        int mod = 1e9+7;
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= 1000; ++j) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
        return dp[k][endPos];
    }
};