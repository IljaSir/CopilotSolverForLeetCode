class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size();
        int m = multipliers.size();
        vector<vector<int>> dp(m+1, vector<int>(m+1, INT_MIN));
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int k = i - j;
                if (j > 0) {
                    dp[j][k] = max(dp[j][k], dp[j-1][k] + nums[j-1] * multipliers[i]);
                }
                if (k > 0) {
                    dp[j][k] = max(dp[j][k], dp[j][k-1] + nums[n-k] * multipliers[i]);
                }
            }
        }
        return *max_element(dp[m].begin(), dp[m].end());
    }
};