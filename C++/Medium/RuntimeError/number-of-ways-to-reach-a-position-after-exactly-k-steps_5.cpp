class Solution {
public:
    int numberOfWays(int startPos, int endPos, int k) {
        
        vector<vector<int>> dp(k + 1, vector<int>(2 * k + 1, 0));
        dp[0][startPos] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j < 2 * k + 1; ++j) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000007;
            }
        }
        return dp[k][endPos];
    }
};