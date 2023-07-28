class Solution {
public:
    int numTilings(int n) {
        
        int M = 1000000007;
        vector<long long> dp(n + 1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * dp[i - 3]) % M;
        }
        return dp[n];
    }
};