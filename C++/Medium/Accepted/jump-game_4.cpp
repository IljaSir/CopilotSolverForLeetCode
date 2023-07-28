class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return true;
        vector<bool> dp(n, false);
        dp[0] = true;
        for (int i = 0; i < n; ++i) {
            if (dp[i]) {
                for (int j = 1; j <= nums[i]; ++j) {
                    if (i + j >= n) return true;
                    dp[i + j] = true;
                }
            }
        }
        return dp[n - 1];
    }
};