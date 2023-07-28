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
        for (int i = 0; i < maxTime; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dp[j][i] == -1) continue;
                for (auto& p : g[j]) {
                    int k = p.first, t = p.second;
                    dp[k][i + t] = max(dp[k][i + t], dp[j][i] + values[k]);
                    res = max(res, dp[k][i + t]);
                }
            }
        }
        return res;
    }
};