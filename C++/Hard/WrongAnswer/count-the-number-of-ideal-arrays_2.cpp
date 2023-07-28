class Solution {
public:
    int idealArrays(int n, int maxValue) {
        
        int MOD = 1e9 + 7;
        vector<long> dp(n + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= maxValue; ++i) {
            for (int j = n; j >= 1; --j) {
                dp[j] = (dp[j] + dp[j - 1] * i) % MOD;
            }
        }
        return dp[n];
    }
};