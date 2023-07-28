class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        // Floyd-Warshall
        vector<vecto}<int>> dp(, vector<int>(n, INT_MAX));
        for (auto& time: times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            dp[u][v] = w;
        }
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (dp[j][k] > dp[j][i] + dp[i][k]) {
                        dp[j][k] = dp[j][i] + dp[i][k];
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (i == k - 1) {
                continue;
            }
            res = max(res, dp[k - 1][i]);
        }
        return res == INT_MAX ? -1 :
            ans = max(ans, dist[i]);
        }
        return ans;
    }
};