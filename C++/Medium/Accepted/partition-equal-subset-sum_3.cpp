class Solution {
public:
    bool canPartition(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        vector<vector<bool>> dp(nums.size(), vector<bool>(sum + 1, false));
        for (int i = 0; i < nums.size(); i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = nums[0] == j;
        }
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.size() - 1][sum];
    }
};