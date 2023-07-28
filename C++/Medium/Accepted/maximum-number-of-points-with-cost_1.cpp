class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int m = points.size();
        int n = points[0].size();
        vector<long long> dp(n, 0);
        for (int i = 0; i < m; i++) {
            vector<long long> maxLeft(n, 0);
            vector<long long> maxRight(n, 0);
            maxLeft[0] = dp[0];
            for (int j = 1; j < n; j++) {
                maxLeft[j] = max(maxLeft[j - 1] - 1, dp[j]);
            }
            maxRight[n - 1] = dp[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                maxRight[j] = max(maxRight[j + 1] - 1, dp[j]);
            }
            for (int j = 0; j < n; j++) {
                dp[j] = points[i][j] + max(maxLeft[j], maxRight[j]);
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};