class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<int> res(n - 1);
        for (int mask = 1; mask < (1 << n); ++mask) {
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) ++cnt;
            }
            if (cnt <= 1) continue;
            vector<vector<int>> g(n);
            for (auto& e : edges) {
                int u = e[0] - 1, v = e[1] - 1;
                if ((mask & (1 << u)) && (mask & (1 << v))) {
                    g[u].push_back(v);
                    g[v].push_back(u);
                }
            }
            vector<int> dist(n, -1);
            queue<int> q;
            q.push(0);
            dist[0] = 0;
            while (!q.empty()) {
                int u = q.front(); q.pop();
                for (int v : g[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        q.push(v);
                    }
                }
            }
            int maxDist = 0;
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    maxDist = max(maxDist, dist[i]);
                }
            }
            ++res[maxDist - 1];
        }
        return res;
    }
};