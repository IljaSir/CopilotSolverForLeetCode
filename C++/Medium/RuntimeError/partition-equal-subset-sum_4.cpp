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
        int target = sum / 2;
        vector<vector<bool> > dp(nums.size(), vector<bool>(target + 1, false));
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j <= target; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (j >= nums[i] && dp[i - 1][j - nums[i]]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.size() - 1][target];
    }
};