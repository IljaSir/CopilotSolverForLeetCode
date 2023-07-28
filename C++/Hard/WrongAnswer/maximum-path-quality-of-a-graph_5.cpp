class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<pair<int, int>>> graph(n);
        for (auto& edge: edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
            graph[edge[1]].push_back({edge[0], edge[2]});
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, INT_MIN));
        dp[0][0] = values[0];
        for (int t = 0; t < maxTime; t++) {
            for (int i = 0; i < n; i++) {
                if (dp[i][t] == INT_MIN) continue;
                for (auto& edge: graph[i]) {
                    int j = edge.first, w = edge.second;
                    if (t + w > maxTime) continue;
                    dp[j][t + w] = max(dp[j][t + w], dp[i][t] + values[j]);
                }
            }
        }
        return *max_element(dp[0].begin(), dp[0].end());
    }
};