class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        vector<vector<int>> dp(n+1, vector<int>(sum+1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        int ans = 0;
        for (int i = k; i <= sum; ++i) {
            ans += dp[n][i];
        }
        return ans;
    }
};