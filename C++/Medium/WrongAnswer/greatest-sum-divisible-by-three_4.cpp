class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        
        int n = nums.size();
        int dp[n][3];
        dp[0][0] = 0;
        dp[0][1] = nums[0] % 3 == 1 ? nums[0] : INT_MIN;
        dp[0][2] = nums[0] % 3 == 2 ? nums[0] : INT_MIN;
        for (int i = 1; i < n; ++i) {
            dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][2] + nums[i]);
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + nums[i]);
        }
        return max(dp[n - 1][0], max(dp[n - 1][1], dp[n - 1][2]));
    }
};