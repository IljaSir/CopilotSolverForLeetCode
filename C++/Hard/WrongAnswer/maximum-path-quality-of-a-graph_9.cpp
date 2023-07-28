class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<pair<int, int>>> graph(n);
        vector<vector<int>> dp(n, vector<int>(maxTime+1, INT_MIN));
        for (auto& e : edges) {
            graph[e[0]].push_back({e[1], e[2]});
            graph[e[1]].push_back({e[0], e[2]});
        }
        dp[0][0] = values[0];
        int ans = values[0];
        for (int t = 1; t <= maxTime; ++t) {
            for (int i = 0; i < n; ++i) {
                dp[i][t] = dp[i][t-1];
                for (auto& e : graph[i]) {
                    if (t >= e.second) {
                        dp[i][t] = max(dp[i][t], dp[e.first][t-e.second]);
                    }
                }
                if (dp[i][t] != INT_MIN) {
                    dp[i][t] += values[i];
                    ans = max(ans, dp[i][t]);
                }
            }
        }
        return ans;
    }
};