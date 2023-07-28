class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        
        int n = differences.size();
        int mod = 1e9 + 7;
        long long dp[n + 1][2];
        memset(dp, 0, sizeof(dp));
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            long long l = dp[i - 1][0] * (lower - 1) + dp[i - 1][1];
            long long r = dp[i - 1][0] * (upper + 1) + dp[i - 1][1];
            l = max(l, (long long)0);
            r = max(r, (long long)0);
            dp[i][0] = (r - l) % mod;
            dp[i][1] = (r - dp[i - 1][0] * differences[i - 1]) % mod;
        }
        return dp[n][0];
    }
};