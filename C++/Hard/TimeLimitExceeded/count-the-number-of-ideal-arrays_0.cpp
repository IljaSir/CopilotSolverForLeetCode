class Solution {
public:
    int idealArrays(int n, int maxValue) {
        
        const int MOD = 1e9 + 7;
        vector<long long> dp(maxValue + 1, 1);
        for (int i = 2; i <= n; ++i) {
            vector<long long> ndp(maxValue + 1);
            for (int j = 1; j <= maxValue; ++j) {
                ndp[j] = dp[j];
                for (int k = 2 * j; k <= maxValue; k += j) {
                    ndp[j] += dp[k];
                    if (ndp[j] >= MOD) {
                        ndp[j] -= MOD;
                    }
                }
            }
            dp = ndp;
        }
        long long ans = 0;
        for (int i = 1; i <= maxValue; ++i) {
            ans += dp[i];
            if (ans >= MOD) {
                ans -= MOD;
            }
        }
        return ans;
    }
};