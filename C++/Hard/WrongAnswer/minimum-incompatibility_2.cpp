class Solution {
public:
    int minimumIncompatibility(vector<int>& nums, int k) {
        
        int n = nums.size();
        int m = n / k;
        vector<int> dp(1 << n, INT_MAX / 2);
        dp[0] = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            vector<int> cnt(n + 1);
            int maxNum = 0, minNum = n + 1;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    cnt[nums[i]]++;
                    maxNum = max(maxNum, nums[i]);
                    minNum = min(minNum, nums[i]);
                }
            }
            bool valid = true;
            for (int i = 1; i <= n; i++) {
                if (cnt[i] > 1) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }
            for (int sub = mask; sub; sub = (sub - 1) & mask) {
                if (__builtin_popcount(sub) == m) {
                    dp[mask] = min(dp[mask], dp[mask ^ sub] + maxNum - minNum);
                }
            }
        }
        int ans = dp[(1 << n) - 1];
        return ans >= INT_MAX / 2 ? -1 : ans;
    }
};