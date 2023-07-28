class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        
        int n = differences.size();
        int mod = 1e9 + 7;
        vector<long long> dp(n + 1, 0);
        dp[0] = 1;
        long long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += differences[i];
            dp[i + 1] = sum - upper;
            dp[i + 1] = max(dp[i + 1], 0LL);
            if (sum >= lower) {
                dp[i + 1] = (dp[i + 1] + min(sum, (long long)upper) - lower + 1) % mod;
            }
            if (i > 0) {
                dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
            }
        }
        return dp[n];
    }
};