class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int m = points.size();
        int n = points[0].size();
        vector<long long> dp(n, 0);
        for (int i = 0; i < m; i++) {
            vector<long long> dp2(n, 0);
            vector<long long> dp3(n, 0);
            for (int j = 0; j < n; j++) {
                dp2[j] = dp[j] - j;
            }
            for (int j = n - 1; j >= 0; j--) {
                dp3[j] = dp[j] + j;
            }
            for (int j = 0; j < n; j++) {
                dp[j] = max(dp2[j], dp3[j]) + points[i][j];
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};