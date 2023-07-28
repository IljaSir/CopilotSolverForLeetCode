class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        vector<int> dp(n + 1, 0);
        unordered_map<int, int> m;
        m[0] = 0;
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i + 1] = dp[i];
            if (m.count(sum - target)) {
                dp[i + 1] = max(dp[i + 1], dp[m[sum - target]] + 1);
            }
            m[sum] = i + 1;
        }
        return dp[n];
    }
};