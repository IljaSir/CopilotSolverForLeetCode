class Solution {
public:
    int numberOfGoodSubsets(vector<int>& nums) {
        
        int MOD = 1e9 + 7;
        int N = 31;
        vector<int> primes = {2,3,5,7,11,13,17,19,23,29};
        vector<int> cnt(N, 0);
        for (int x: nums) cnt[x]++;
        vector<int> dp(N, 0);
        dp[1] = 1;
        for (int p: primes) {
            for (int i = N - 1; i >= p; --i) {
                dp[i] = (dp[i] + dp[i - p]) % MOD;
            }
        }
        int ans = 0;
        for (int i = 1; i < N; ++i) {
            int sign = __builtin_popcount(i) % 2 == 1 ? 1 : -1;
            ans = (ans + sign * dp[i] * cnt[i]) % MOD;
        }
        return (ans + MOD) % MOD;
    }
};