class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        for (int mask = 1; mask < (1 << n); ++mask) {
            int sum = start;
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    sum += nums[i];
                }
            }
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    dp[mask] = min(dp[mask], dp[mask ^ (1 << i)] + abs(sum - nums[i] - goal));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};