class Solution {
public:
    int numberOfWays(string corridor) {
        
        int n = corridor.size();
        int mod = 1e9 + 7;
        vector<long long> dp(n, 0);
        int cur = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (corridor[i] == 'S') {
                cur++;
            } else {
                cnt++;
            }
            if (i == 0) {
                dp[i] = 1;
            } else {
                dp[i] = cur * dp[i - 1] % mod;
                if (cnt >= 2) {
                    dp[i] = (dp[i] + (cnt - 1) * dp[i - 1] % mod) % mod;
                }
            }
        }
        return dp[n - 1];
    }
};