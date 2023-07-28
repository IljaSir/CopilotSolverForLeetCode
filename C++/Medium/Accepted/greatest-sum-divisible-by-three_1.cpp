class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(3, 0));
        dp[0][nums[0] % 3] = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            for (int j = 0; j < 3; j++) {
                int k = (nums[i] + dp[i - 1][j]) % 3;
                dp[i][k] = max(dp[i][k], nums[i] + dp[i - 1][j]);
            }
        }
        return dp[n - 1][0];
    }
};