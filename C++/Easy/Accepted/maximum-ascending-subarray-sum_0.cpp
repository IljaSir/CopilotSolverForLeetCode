class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];
            if (nums[i] > nums[i-1]) {
                dp[i] += dp[i-1];
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};