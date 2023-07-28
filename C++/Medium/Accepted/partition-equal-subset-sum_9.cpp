class Solution {
public:
    bool canPartition(vector<int>& nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum & 1) {
            return false;
        }
        int n = nums.size(), target = sum / 2;
        vector<vector<bool>> dp(n + 1, vector<bool>(target + 1));
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
};