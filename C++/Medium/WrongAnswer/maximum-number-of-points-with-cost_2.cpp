class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        int m = points[0].size();
        vector<long long> dp(m, 0);
        for (int i = 0; i < n; i++) {
            vector<long long> ndp(m, 0);
            long long maxv = dp[0];
            for (int j = 1; j < m; j++) {
                maxv = max(maxv, dp[j] + j);
            }
            for (int j = 0; j < m; j++) {
                ndp[j] = max(maxv - j, dp[j] - j) + points[i][j];
            }
            maxv = dp[m - 1];
            for (int j = m - 2; j >= 0; j--) {
                maxv = max(maxv, dp[j] - j);
            }
            for (int j = m - 1; j >= 0; j--) {
                ndp[j] = max(maxv + j, ndp[j]);
            }
            swap(dp, ndp);
        }
        long long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};