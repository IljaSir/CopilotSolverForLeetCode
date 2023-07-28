class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size(), m = nums2.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, INT_MIN));
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = INT_MIN / 2;
                } else {
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
                    dp[i][j] = max(dp[i][j], dp[i - 1][j]);
                    dp[i][j] = max(dp[i][j], dp[i][j - 1]);
                    dp[i][j] = max(dp[i][j], nums1[i - 1] * nums2[j - 1]);
                }
            }
        }
        return dp[n][m];
    }
};