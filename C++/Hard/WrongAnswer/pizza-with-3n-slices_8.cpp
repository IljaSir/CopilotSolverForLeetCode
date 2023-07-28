class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size() / 3;
        int m = slices.size();
        vector<int> a(slices.begin(), slices.end());
        vector<int> b(slices.begin() + 1, slices.end());
        return max(solve(a, n), solve(b, n));
    }
    int solve(vector<int>& slices, int n) {
        int m = slices.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= min(i, n); j++) {
                dp[i][j] = max(dp[i - 1][j], (i >= 2 ? dp[i - 2][j - 1] : 0) + slices[i - 1]);
            }
        }
        return dp[m][n];
    }
};