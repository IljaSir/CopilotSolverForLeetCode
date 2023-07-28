class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sums(n+1, 0);
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        vector<vector<double>> dp(n+1, vector<double>(n+1, 0));
        for (int i = 1; i <= n; i++) {
            dp[i][1] = (double)sums[i] / i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int p = 1; p < i; p++) {
                    dp[i][j] = max(dp[i][j], dp[p][j-1] + (double)(sums[i]-sums[p]) / (i-p));
                }
            }
        }
        return dp[n][k];
    }
};