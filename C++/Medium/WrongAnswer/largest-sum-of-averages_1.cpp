class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<double> sums(n+1, 0);
        for (int i = 0; i < n; ++i) {
            sums[i+1] = sums[i] + nums[i];
        }
        vector<vector<double>> dp(n, vector<double>(k, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][0] = (sums[n] - sums[i]) / (n - i);
            for (int j = 1; j < k; ++j) {
                for (int l = i+1; l < n; ++l) {
                    dp[i][j] = max(dp[i][j], dp[l][j-1] + (sums[l] - sums[i]) / (l - i));
                }
            }
        }
        return dp[0][k-1];
    }
};