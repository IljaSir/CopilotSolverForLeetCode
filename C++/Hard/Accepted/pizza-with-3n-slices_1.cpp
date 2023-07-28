class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size();
        int m = n / 3;
        vector<int> v1(slices.begin(), slices.end() - 1);
        vector<int> v2(slices.begin() + 1, slices.end());
        return max(maxSum(v1, m), maxSum(v2, m));
    }
    int maxSum(vector<int> &slices, int m) {
        int n = slices.size();
        vector<vector<int>> dp(m + 1, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[1][i] = slices[i];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = i - 1; j < n; j++) {
                for (int k = j - 2; k >= i - 2; k--) {
                    dp[i][j] = max(dp[i][j], dp[i - 1][k] + slices[j]);
                }
            }
        }
        int res = 0;
        for (int i = m - 1; i < n; i++) {
            res = max(res, dp[m][i]);
        }
        return res;
    }
};