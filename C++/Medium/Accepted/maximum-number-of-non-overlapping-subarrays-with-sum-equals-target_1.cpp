class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        unordered_map<int, int> m;
        m[0] = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (m.count(sum - target)) {
                if (m[sum - target] != -1) {
                    dp[i] = dp[m[sum - target]] + 1;
                } else {
                    dp[i] = 1;
                }
            }
            if (i > 0) {
                dp[i] = max(dp[i], dp[i - 1]);
            }
            m[sum] = i;
        }
        return dp[n - 1];
    }
};