class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size();
        slices.insert(slices.end(), slices.begin(), slices.end());
        int max_sum = 0;
        for (int i = 0; i < n; ++i) {
            max_sum = max(max_sum, maxSum(slices, i, i + n - 1));
        }
        return max_sum;
    }
    int maxSum(vector<int>& slices, int start, int end) {
        int n = end - start + 1;
        vector<vector<int>> dp(n, vector<int>(n / 3 + 1, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][1] = slices[start + i];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 2; j <= min(i + 1, n / 3); ++j) {
                dp[i][j] = dp[i - 1][j];
                if (i - 2 >= 0) {
                    dp[i][j] = max(dp[i][j], dp[i - 2][j - 1] + slices[start + i]);
                }
            }
        }
        return dp[n - 1][n / 3];
    }
};