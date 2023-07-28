class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        int m = points[0].size();
        vector<vector<long long>> dp(n, vector<long long>(m, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0) {
                    dp[i][j] = points[i][j];
                    continue;
                }
                long long cur = dp[i - 1][j] + points[i][j];
                for (int k = 0; k < m; ++k) {
                    if (k == j) continue;
                    cur = max(cur, dp[i - 1][k] - abs(k - j) + points[i][j]);
                }
                dp[i][j] = cur;
            }
        }
        long long ans = 0;
        for (int i = 0; i < m; ++i) {
            ans = max(ans, dp[n - 1][i]);
        }
        return ans;
    }
};