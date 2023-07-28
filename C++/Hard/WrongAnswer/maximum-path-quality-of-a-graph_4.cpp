class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].emplace_back(e[1], e[2]);
            graph[e[1]].emplace_back(e[0], e[2]);
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, INT_MIN));
        dp[0][0] = values[0];
        int res = 0;
        for (int t = 1; t <= maxTime; ++t) {
            for (int i = 0; i < n; ++i) {
                for (auto& [j, time] : graph[i]) {
                    if (t >= time && dp[j][t - time] != INT_MIN) {
                        dp[i][t] = max(dp[i][t], dp[j][t - time] + values[i]);
                        if (i == 0) res = max(res, dp[i][t]);
                    }
                }
            }
        }
        return res;
    }
};