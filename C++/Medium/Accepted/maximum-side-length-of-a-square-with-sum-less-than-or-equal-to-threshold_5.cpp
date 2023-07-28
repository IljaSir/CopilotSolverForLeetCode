class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + mat[i][j];
            }
        }
        int l = 0, r = min(m, n);
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            bool ok = false;
            for (int i = mid; i <= m; i++) {
                for (int j = mid; j <= n; j++) {
                    if (dp[i][j] - dp[i - mid][j] - dp[i][j - mid] + dp[i - mid][j - mid] <= threshold) {
                        ok = true;
                    }
                }
            }
            if (ok) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
};