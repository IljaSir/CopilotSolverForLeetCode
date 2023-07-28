class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int m = points.size();
        int n = points[0].size();
        vector<long long> dp(n);
        long long maxVal = 0;
        for (int i = 0; i < m; i++) {
            vector<long long> next(n);
            long long best = 0;
            for (int j = 0; j < n; j++) {
                best = max(best, dp[j] + j);
                next[j] = best - j + points[i][j];
            }
            best = 0;
            for (int j = n - 1; j >= 0; j--) {
                best = max(best, dp[j] - j);
                next[j] = max(next[j], best + j + points[i][j]);
            }
            dp = next;
        }
        for (int i = 0; i < n; i++) {
            maxVal = max(maxVal, dp[i]);
        }
        return maxVal;
    }
};