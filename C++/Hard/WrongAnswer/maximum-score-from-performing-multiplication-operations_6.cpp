class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size();
        int m = multipliers.size();
        vector<vector<int>> dp(m+1, vector<int>(m+1, 0));
        for (int i = 0; i < m; i++) {
            dp[i][0] = dp[i][i] = nums[i] * multipliers[i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = max(dp[i-1][j] + nums[i] * multipliers[i], dp[i-1][j+1] + nums[n-i-1] * multipliers[i]);
            }
        }
        int ans = INT_MIN;
        for (int i = 0; i < m; i++) {
            ans = max(ans, dp[m-1][i]);
        }
        return ans;
    }
};