class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        
        int n = differences.size();
        vector<long> dp(n + 1);
        dp[0] = 1;
        long mod = 1e9 + 7;
        for (int i = 1; i <= n; ++i) {
            dp[i] = (dp[i - 1] * (upper - lower + 1)) % mod;
            if (i > 1) {
                int diff = differences[i - 2];
                if (diff > 0) {
                    dp[i] = (dp[i] - (dp[i - 2] * max(0, upper - diff - lower + 1)) % mod + mod) % mod;
                } else {
                    dp[i] = (dp[i] - (dp[i - 2] * max(0, upper + diff - lower + 1)) % mod + mod) % mod;
                }
            }
        }
        return dp[n];
    }
};