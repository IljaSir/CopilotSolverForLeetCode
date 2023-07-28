class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto& e: edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        int ans = n + 1;
        for (int i = 0; i < n; ++i) {
            queue<pair<int, int>> q;
            vector<int> dist(n, n + 1);
            q.emplace(i, -1);
            dist[i] = 0;
            while (!q.empty()) {
                auto [u, p] = q.front();
                q.pop();
                for (auto v: adj[u]) {
                    if (v == p) continue;
                    if (dist[v] == n + 1) {
                        dist[v] = dist[u] + 1;
                        q.emplace(v, u);
                    } else {
                        ans = min(ans, dist[u] + dist[v] + 1);
                    }
                }
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
};