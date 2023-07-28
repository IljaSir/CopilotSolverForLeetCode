class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sums(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        vector<vector<int>> dp(k + 1, vector<int>(n + 1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int p = i - 1; p < j; p++) {
                    dp[i][j] = min(dp[i][j], max(dp[i - 1][p], sums[j] - sums[p]));
                }
            }n];
    }
};