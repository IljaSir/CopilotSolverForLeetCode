class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        double dp[n + 1][k + 1];
        double sum[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[i][1] = sum[i] / i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int p = 1; p < i; p++) {
                    dp[i][j] = max(dp[i][j], dp[p][j - 1] + (sum[i] - sum[p]) / (i - p));
                }
            }
        }
        return dp[n][k];
    }
};