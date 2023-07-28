class Solution {
public:
    int numberOfWays(int startPos, int endPos, int k) {
        
        int mod = 1e9 + 7;
        int dp[1001][1001];
        memset(dp, 0, sizeof(dp));
        dp[startPos][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= 1000; j++) {
                dp[j][i + 1] += dp[j - 1][i];
                dp[j][i + 1] %= mod;
                dp[j][i + 1] += dp[j + 1][i];
                dp[j][i + 1] %= mod;
            }
        }
        return dp[endPos][k];
    }
};