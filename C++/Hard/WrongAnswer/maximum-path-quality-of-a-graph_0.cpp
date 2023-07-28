class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<pair<int, int>>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, -1));
        dp[0][0] = values[0];
        int res = 0;
        for (int t = 1; t <= maxTime; ++t) {
            for (int i = 0; i < n; ++i) {
                for (auto& e : g[i]) {
                    int j = e.first, w = e.second;
                    if (t - w >= 0 && dp[j][t - w] != -1) {
                        dp[i][t] = max(dp[i][t], dp[j][t - w] + values[i]);
                        res = max(res, dp[i][t]);
                    }
                }
            }
        }
        return res;
    }
};