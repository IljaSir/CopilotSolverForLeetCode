class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        int n = nums.size();
        int M = 1e9 + 7;
        vector<int> dp(3, 0);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                dp[0] = 2 * dp[0] + 1;
            }
            if (nums[i] == 1) {
                dp[1] = 2 * dp[1] + dp[0];
            }
            if (nums[i] == 2) {
                dp[2] = 2 * dp[2] + dp[1];
            }
            for (int j = 0; j < 3; j++) {
                dp[j] %= M;
            }
        }
        return dp[2];
    }
};