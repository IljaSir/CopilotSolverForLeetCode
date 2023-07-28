class Solution {
public:
    int minDeletion(vector<int>& nums) {
        
        int n = nums.size();
        int dp[n];
        dp[0] = 0;
        dp[1] = nums[0] == nums[1] ? 1 : 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 2];
            }
        }
        return dp[n - 1];
    }
};