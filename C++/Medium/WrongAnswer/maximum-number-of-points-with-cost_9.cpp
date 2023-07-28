class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        
        int m = points.size();
        int n = points[0].size();
        vector<vector<long long>> dp(m, vector<long long>(n, 0));
        vector<long long> mins(n, 0), maxs(n, 0);
        for (int i = 0; i < n; ++i) {
            dp[0][i] = points[0][i];
            mins[i] = i;
            maxs[i] = i;
        }
        for (int i = 1; i < m; ++i) {
            vector<long long> nmins(n, 0), nmaxs(n, 0);
            for (int j = 0; j < n; ++j) {
                dp[i][j] = points[i][j] + max(dp[i - 1][mins[j]], dp[i - 1][maxs[j]]);
                nmins[j] = mins[j];
                nmaxs[j] = maxs[j];
            }
            for (int j = 1; j < n; ++j) {
                if (dp[i][j] > dp[i][nmins[j]]) {
                    nmins[j] = j;
                }
                if (dp[i][j] > dp[i][nmaxs[j]]) {
                    nmaxs[j] = j;
                }
            }
            for (int j = n - 2; j >= 0; --j) {
                if (dp[i][j] > dp[i][nmins[j]]) {
                    nmins[j] = j;
                }
                if (dp[i][j] > dp[i][nmaxs[j]]) {
                    nmaxs[j] = j;
                }
            }
            mins = nmins;
            maxs = nmaxs;
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, dp[m - 1][i]);
        }
        return ans;
    }
};