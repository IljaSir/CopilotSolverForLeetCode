class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        
        vector<vector<int>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        unordered_set<int> rs(restricted.begin(), restricted.end());
        vector<int> dist(n, INT_MAX);
        dist[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int u = q.front(); q.pop();
            for (int v : g[u]) {
                if (rs.count(v)) continue;
                if (dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (dist[i] != INT_MAX) {
                res++;
            }
        }
        for (auto &e : edges) {
            int d = min(dist[e[0]] + dist[e[1]], e[2]);
            if (dist[e[0]] != INT_MAX) {
                res += max(0, d - dist[e[0]]);
            }
            if (dist[e[1]] != INT_MAX) {
                res += max(0, d - dist[e[1]]);
            }
        }
        return res;
    }
};