class Solution {
public:
    bool splitArraySameAverage(vector<int>& nums) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        vector<vector<bool>> dp(n + 1, vector<bool>(sum + 1, false));
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (sum * i % n == 0 && dp[i][sum * i / n]) {
                return true;
            }
        }
        return false;
    }
};