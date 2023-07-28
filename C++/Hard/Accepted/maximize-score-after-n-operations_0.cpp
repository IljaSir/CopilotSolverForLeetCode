class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size() / 2;
        vector<vector<int>> dp(n + 1, vector<int>(1 << (2 * n), -1));
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int mask = 0; mask < (1 << (2 * n)); ++mask) {
                if (dp[i][mask] == -1) continue;
                for (int j = 0; j < 2 * n; ++j) {
                    if (mask & (1 << j)) continue;
                    for (int k = j + 1; k < 2 * n; ++k) {
                        if (mask & (1 << k)) continue;
                        int nmask = mask | (1 << j) | (1 << k);
                        dp[i + 1][nmask] = max(dp[i + 1][nmask], dp[i][mask] + (i + 1) * __gcd(nums[j], nums[k]));
                    }
                }
            }
        }
        return dp[n][(1 << (2 * n)) - 1];
    }
};