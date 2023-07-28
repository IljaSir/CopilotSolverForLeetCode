class Solution {
public:
    int rob(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return nums[0];
        return max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    int rob(vector<int>& nums, int start, int end) {
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[start] = nums[start];
        dp[start + 1] = max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
};