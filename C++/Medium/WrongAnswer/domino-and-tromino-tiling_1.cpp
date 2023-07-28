class Solution {
public:
    int numTilings(int n) {
        
        vector<long long> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            for (int j = 1; j <= i - 2; j++) {
                dp[i] = (dp[i] + dp[j] * dp[i - j - 1]) % 1000000007;
            }
        }
        return dp[n];
    }
};