class Solution {
public:
    int numberOfWays(int startPos, int endPos, int k) {
        
        // dp[i][j] means the number of ways to reach j after i steps
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
        // dp[0][startPos] = 1
        // dp[i][j] = 0 if j < 1
        // return dp[k][endPos]
        // Time: O(k * endPos)
        // Space: O(k * endPos)
        const int mod = 1e9 + 7;
        vector<vector<int>> dp(k + 1, vector<int>(endPos + 1, 0));
        dp[0][startPos] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= endPos; ++j) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
        return dp[k][endPos];
    }
};