class Solution {
public:
    int minSpaceWastedKResizing(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(k + 1, INT_MAX / 2));
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; ++i) {
            dp[i][0] = (sum[n] - sum[i]) - (n - i) * nums[i];
        }
        for (int j = 1; j <= k; ++j) {
            for (int i = 0; i < n; ++i) {
                int maxVal = nums[i];
                for (int p = i; p < n; ++p) {
                    maxVal = max(maxVal, nums[p]);
                    dp[i][j] = min(dp[i][j], dp[p + 1][j - 1] + (sum[p + 1] - sum[i]) - (p - i + 1) * maxVal);
                }
            }
        }
        return dp[0][k];
    }
};