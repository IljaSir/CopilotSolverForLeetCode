class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int m = points.size();
        int n = points[0].size();
        vector<long long> dp(n, 0);
        for (int i = 0; i < m; i++) {
            long long maxVal = 0;
            vector<long long> next(n, 0);
            for (int j = 0; j < n; j++) {
                maxVal = max(maxVal, dp[j] + j);
                next[j] = max(maxVal - j, next[j]);
            }
            maxVal = 0;
            for (int j = n - 1; j >= 0; j--) {
                maxVal = max(maxVal, dp[j] - j);
                next[j] = max(maxVal + j, next[j]);
            }
            for (int j = 0; j < n; j++) {
                next[j] += points[i][j];
            }
            dp = next;
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};