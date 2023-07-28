class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<double> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<double> dp(n, 0);
        for (int i = 0; i < n; i++) {
            dp[i] = (sum[n] - sum[i]) / (n - i);
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    dp[j] = max(dp[j], (sum[l] - sum[j]) / (l - j) + dp[l]);
                }
            }
        }
        return dp[0];
    }
};