class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        vector<vector<pair<int, int>>> g(values.size());
        for (auto &e: edges) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> dp(values.size(), vector<int>(maxTime + 1));
        dp[0][0] = values[0];
        int ans = 0;
        for (int i = 0; i <= maxTime; ++i) {
            for (int j = 0; j < values.size(); ++j) {
                for (auto &e: g[j]) {
                    if (i + e.second > maxTime) continue;
                    dp[e.first][i + e.second] = max(dp[e.first][i + e.second], dp[j][i] + values[e.first]);
                    ans = max(ans, dp[e.first][i + e.second]);
                }
            }
        }
        return ans;
    }
};