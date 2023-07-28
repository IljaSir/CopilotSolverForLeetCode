class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<vector<int>> dp(1 << n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; ++i) {
            dp[1 << i][i] = tasks[i][2];
        }
        for (int mask = 1; mask < (1 << n); ++mask) {
            for (int i = 0; i < n; ++i) {
                if (!(mask & (1 << i))) continue;
                for (int j = 0; j < n; ++j) {
                    if (mask & (1 << j)) continue;
                    if (tasks[j][0] <= tasks[i][1] && tasks[j][1] >= tasks[i][1]) {
                        dp[mask | (1 << j)][j] = min(dp[mask | (1 << j)][j], dp[mask][i] + tasks[j][2]);
                    } else {
                        dp[mask | (1 << j)][j] = min(dp[mask | (1 << j)][j], dp[mask][i] + tasks[j][2] + tasks[i][1] - tasks[j][0]);
                    }
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            ans = min(ans, dp[(1 << n) - 1][i]);
        }
        return ans;
    }
};