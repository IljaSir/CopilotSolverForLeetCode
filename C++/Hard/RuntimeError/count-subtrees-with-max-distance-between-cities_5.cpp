class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<int> ans(n - 1, 0);
        for (int mask = 1; mask < (1 << n); mask++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) cnt++;
            }
            if (cnt <= 1) continue;
            vector<vector<int>> g(n);
            for (auto e : edges) {
                if ((mask & (1 << (e[0] - 1))) && (mask & (1 << (e[1] - 1)))) {
                    g[e[0] - 1].push_back(e[1] - 1);
                    g[e[1] - 1].push_back(e[0] - 1);
                }
            }
            queue<int> q;
            vector<int> dist(n, -1);
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    q.push(i);
                    dist[i] = 0;
                    break;
                }
            }
            int maxDist = 0;
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                maxDist = max(maxDist, dist[u]);
                for (auto v : g[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        q.push(v);
                    }
                }
            }
            ans[maxDist - 1]++;
        }
        return ans;
    }
};