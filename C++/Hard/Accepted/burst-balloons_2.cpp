class Solution {
public:
    int maxCoins(vector<int>& nums) {
        
        int n = nums.size();
        nums.insert(nums.begin(), 1);
        nums.insert(nums.end(), 1);
        vector<vector<int>> dp(n + 2, vector<int>(n + 2));
        for (int len = 1; len <= n; ++len) {
            for (int l = 1; l <= n - len + 1; ++l) {
                int r = l + len - 1;
                for (int i = l; i <= r; ++i) {
                    dp[l][r] = max(dp[l][r], dp[l][i - 1] + dp[i + 1][r] + nums[l - 1] * nums[i] * nums[r + 1]);
                }
            }
        }
        return dp[1][n];
    }
};