class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size();
        int m = n / 3;
        return max(maxSizeSlices(slices, 0, n - 2, m), maxSizeSlices(slices, 1, n - 1, m));
    }
    int maxSizeSlices(vector<int>& slices, int l, int r, int m) {
        int n = r - l + 1;
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        for (int i = l; i <= r; i++) {
            dp[1][i - l + 1] = slices[i];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - 2] + slices[l + j - 1]);
            }
        }
        return dp[m][n];
    }
};