class Solution {
public:
    int numberOfGoodSubsets(vector<int>& nums) {
        
        int MOD = 1e9+7;
        vector<int> primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        vector<int> cnt(31);
        for (int x: nums) cnt[x]++;
        vector<int> dp(1024, 0);
        dp[0] = 1;
        for (int x: primes) {
            int mask = 1 << (x - 1);
            for (int i = 1023; i >= 0; i--) {
                if (i & mask) continue;
                dp[i | mask] += dp[i];
                if (dp[i | mask] >= MOD) dp[i | mask] -= MOD;
            }
        }
        int ans = 0;
        for (int i = 1; i <= 30; i++) {
            int mask = 0;
            for (int j = 1; j <= 30; j++) {
                if (j % i == 0) mask |= 1 << (j - 1);
            }
            int ways = 1;
            for (int j = 1; j <= cnt[i]; j++) {
                ways = ways * 1ll * j % MOD;
            }
            ans += dp[mask] * 1ll * ways % MOD;
            if (ans >= MOD) ans -= MOD;
        }
        return ans;
    }
};