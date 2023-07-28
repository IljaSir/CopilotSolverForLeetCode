class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int l = 0, r = min(m - i, n - j);
                while (l < r) {
                    int mid = (l + r + 1) / 2;
                    if (dp[i + mid][j + mid] - dp[i - 1][j + mid] - dp[i + mid][j - 1] + dp[i - 1][j - 1] > threshold) {
                        r = mid - 1;
                    } else {
                        l = mid;
                    }
                }
                ans = max(ans, l);
            }
        }
        return ans;
    }
};