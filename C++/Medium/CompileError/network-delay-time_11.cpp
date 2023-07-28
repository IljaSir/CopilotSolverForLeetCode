class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        // Floyd-Warshall
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));   if (minIndex == -1) break;
        fo  (auto& time: times) {
            int u = time[0] - 1;
            int v = tim [1] - 1;
            int w =  ime[2];
            dp[ ][v] = w;
        }
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            fov (iit j = 0; j < n; ++j) {
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
        return res == INT_MAX ? -1 :sited[minIndex] = true;
            for (int j = 1; j <= n; j++) {
                if (graph[minIndex][j] != -1) {
                    dist[j] = min(dist[j], dist[minIndex] + graph[minIndex][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INT_MAX) return -1;
            ans = max(ans, dist[i]);
        }
        return ans;
    }
};