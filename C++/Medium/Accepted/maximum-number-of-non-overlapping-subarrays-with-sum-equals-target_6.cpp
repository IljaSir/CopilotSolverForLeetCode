class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        vector<int> dp(n+1);
        unordered_map<int, int> m;
        m[0] = 0;
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += nums[i-1];
            dp[i] = dp[i-1];
            if (m.count(sum-target)) {
                dp[i] = max(dp[i], dp[m[sum-target]]+1);
            }
            m[sum] = i;
        }
        return dp[n];
    }
};