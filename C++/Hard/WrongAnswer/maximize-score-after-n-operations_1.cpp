class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size() / 2;
        vector<vector<int>> dp(n + 1, vector<int>(1 << n, 0));
        for (int i = 1; i <= n; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                if (__builtin_popcount(mask) != i) continue;
                for (int j = 0; j < n; j++) {
                    if ((mask >> j) & 1) {
                        for (int k = j + 1; k < n; k++) {
                            if ((mask >> k) & 1) {
                                int nmask = mask ^ (1 << j) ^ (1 << k);
                                dp[i][mask] = max(dp[i][mask], dp[i - 1][nmask] + i * __gcd(nums[j], nums[k + n]));
                            }
                        }
                    }
                }
            }
        }
        return dp[n][(1 << n) - 1];
    }
};