class Solution {
public:
    int numberOfGoodSubsets(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> primes = {2,3,5,7,11,13,17,19,23,29,31};
        vector<int> cnt(32, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        vector<int> dp(1<<11, 0);
        dp[0] = 1;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] == 0) continue;
            int mask = 0;
            for (int j = 0; j < 11; j++) {
                if (i % primes[j] == 0) {
                    mask |= 1 << j;
                }
            }
            for (int j = 0; j < 1 << 11; j++) {
                if (j & mask) continue;
                dp[j | mask] += dp[j] * cnt[i];
                dp[j | mask] %= 1000000007;
            }
        }
        int ans = 0;
        for (int i = 0; i < 1 << 11; i++) {
            int cnt = 0;
            for (int j = 0; j < 11; j++) {
                if (i & (1 << j)) cnt++;
            }
            if (cnt & 1) {
                ans -= dp[i];
            }
            else {
                ans += dp[i];
            }
            ans %= 1000000007;
        }
        return (ans + 1000000007) % 1000000007;
    }
};