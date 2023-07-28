class Solution {
public:
    int maximalPathQuality(vector<int>& values, vector<vector<int>>& edges, int maxTime) {
        
        int n = values.size();
        vector<vector<pair<int, int>>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back({e[1], e[2]});
            adj[e[1]].push_back({e[0], e[2]});
        }
        vector<int> dp(n, INT_MIN);
        dp[0] = values[0];
        queue<pair<int, int>> q;
        q.push({0, 0});
        while (!q.empty()) {
            auto [u, t] = q.front();
            q.pop();
            for (auto [v, w] : adj[u]) {
                if (t + w > maxTime) continue;
                if (dp[v] < dp[u] + values[v]) {
                    dp[v] = dp[u] + values[v];
                    q.push({v, t + w});
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};