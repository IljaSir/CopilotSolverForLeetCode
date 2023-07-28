class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        int dp[1 << n];
        memset(dp, 0, sizeof(dp));
        for (int mask = 1; mask < (1 << n); mask++) {
            int bits = __builtin_popcount(mask);
            if (bits & 1) continue;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    for (int j = i + 1; j < n; j++) {
                        if (mask & (1 << j)) {
                            int newMask = mask ^ (1 << i) ^ (1 << j);
                            dp[mask] = max(dp[mask], dp[newMask] + bits / 2 * __gcd(nums[i], nums[j]));
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};