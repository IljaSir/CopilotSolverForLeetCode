class Solution {
public:
    bool canPartition(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        vector<vector<bool>> dp(nums.size() + 1, vector<bool>(sum + 1, 0));
        for (int i = 0; i <= nums.size(); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.size(); i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.size()][sum];
    }
};