class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size();
        int m = n / 3;
        return max(maxSizeSlices(slices, 0, n - 2, m), maxSizeSlices(slices, 1, n - 1, m));
    }
    int maxSizeSlices(vector<int>& slices, int start, int end, int m) {
        int n = end - start + 1;
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - 2] + slices[start + j - 1]);
            }
        }
        return dp[m][n];
    }
};