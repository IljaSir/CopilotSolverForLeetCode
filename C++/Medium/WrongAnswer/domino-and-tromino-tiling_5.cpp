class Solution {
public:
    int numTilings(int n) {
        
        vector<long> dp(n + 1);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = (dp[i] + dp[i - 1]) % 1000000007;
            if (i >= 2) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000007;
            }
            if (i >= 3) {
                dp[i] = (dp[i] + dp[i - 3] * 2) % 1000000007;
            }
        }
        return dp[n];
    }
};