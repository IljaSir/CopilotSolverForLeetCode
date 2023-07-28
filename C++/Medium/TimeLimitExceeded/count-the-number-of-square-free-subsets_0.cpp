class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1e9 + 7;
        vector<int> cnt(31, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        vector<int> dp(1 << 30, 0);
        dp[0] = 1;
        for (int i = 1; i <= 30; i++) {
            for (int j = (1 << 30) - 1; j >= 0; j--) {
                for (int k = 1; k <= cnt[i]; k++) {
                    int mask = (1 << i) - 1;
                    if ((j & mask) == 0) {
                        dp[j | mask] = (dp[j | mask] + dp[j]) % mod;
                    }
                    mask <<= i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << 30); i++) {
            if (__builtin_popcount(i) & 1) {
                ans = (ans - dp[i] + mod) % mod;
            } else {
                ans = (ans + dp[i]) % mod;
            }
        }
        return ans;
    }
};