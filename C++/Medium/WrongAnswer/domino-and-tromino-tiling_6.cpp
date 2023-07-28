class Solution {
public:
    int numTilings(int n) {
        
        int mod = 1e9 + 7;
        vector<int> dp(n+1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1];
            if (i >= 2) dp[i] = (dp[i] + dp[i-2]) % mod;
            if (i >= 3) dp[i] = (dp[i] + 2LL * dp[i-3]) % mod;
        }
        return dp[n];
    }
};