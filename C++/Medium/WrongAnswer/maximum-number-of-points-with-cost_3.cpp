class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int m = points.size();
        int n = points[0].size();
        vector<long long> dp(n, 0);
        vector<long long> tmp(n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j] = dp[j] + points[i][j];
            }
            long long left = 0;
            long long right = 0;
            for (int j = 0; j < n; j++) {
                left = max(left, dp[j] - j);
                tmp[j] = max(tmp[j], left + j);
            }
            for (int j = n - 1; j >= 0; j--) {
                right = max(right, dp[j] + j);
                tmp[j] = max(tmp[j], right - j);
            }
            dp = tmp;
        }
        return *max_element(dp.begin(), dp.end());
    }
};