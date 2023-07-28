class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        int n = jobs.size();
        int dp[1<<n];
        memset(dp, 0, sizeof(dp));
        for (int mask = 1; mask < (1<<n); mask++) {
            int x = __builtin_ctz(mask);
            int p = mask^(1<<x);
            dp[mask] = dp[p] + jobs[x];
        }
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < (1<<n); mask++) {
                if (mask&(1<<i)) {
                    dp[mask] = min(dp[mask], dp[mask^(1<<i)]);
                }
            }
        }
        int f[1<<n];
        memset(f, 0x3f, sizeof(f));
        f[0] = 0;
        for (int mask = 0; mask < (1<<n); mask++) {
            int left = ((1<<n)-1)^mask;
            for (int s = left; s; s = (s-1)&left) {
                if (dp[s] <= k) {
                    f[mask|s] = min(f[mask|s], max(f[mask], dp[s]));
                }
            }
        }
        return f[(1<<n)-1];
    }
};