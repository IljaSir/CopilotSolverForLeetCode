class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n / 2 + 1, vector<int>(1 << n, 0));
        for (int i = 1; i <= n / 2; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                if (__builtin_popcount(mask) != 2 * i) continue;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if ((mask >> j & 1) && (mask >> k & 1)) {
                            dp[i][mask] = max(dp[i][mask], dp[i - 1][mask ^ (1 << j) ^ (1 << k)] + i * __gcd(nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return dp[n / 2][(1 << n) - 1];
    }
};