class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        
        int n = differences.size();
        vector<long long> dp(n + 1, 0);
        long long mod = 1e9 + 7;
        dp[0] = 1;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += differences[i];
            dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
            long long l = max(lower - sum, 1LL);
            long long r = upper - sum;
            if (l <= r) {
                dp[i + 1] = (dp[i + 1] + (r - l + 1) % mod) % mod;
                if (i + 1 < n) {
                    dp[i + 2] = (dp[i + 2] - (r - l + 1) % mod + mod) % mod;
                }
            }
        }
        return dp[n];
    }
};