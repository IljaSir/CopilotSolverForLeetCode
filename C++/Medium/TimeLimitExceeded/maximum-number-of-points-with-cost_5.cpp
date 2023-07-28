class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        long long ans = 0;
        int m = points.size();
        int n = points[0].size();
        vector<long long> dp(n, 0);
        for (int i = 0; i < m; ++i) {
            vector<long long> ndp(n, 0);
            for (int j = 0; j < n; ++j) {
                ndp[j] = max(ndp[j], dp[j] + points[i][j]);
                for (int k = j + 1; k < n; ++k) {
                    ndp[k] = max(ndp[k], dp[j] + points[i][k] - (k - j));
                }
                for (int k = j - 1; k >= 0; --k) {
                    ndp[k] = max(ndp[k], dp[j] + points[i][k] - (j - k));
                }
            }
            dp = ndp;
        }
        for (int i = 0; i < n; ++i) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};