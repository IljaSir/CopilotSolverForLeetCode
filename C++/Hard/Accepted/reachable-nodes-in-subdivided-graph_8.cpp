class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int,int>>> g(n);
        for (auto &e: edges) {
            g[e[0]].push_back({e[1], e[2]+1});
            g[e[1]].push_back({e[0], e[2]+1});
        }
        priority_queue<pair<int,int>> q;
        q.push({maxMoves, 0});
        vector<int> dist(n, -1);
        while (!q.empty()) {
            auto [d, u] = q.top();
            q.pop();
            if (dist[u] > d) continue;
            dist[u] = d;
            for (auto [v, w]: g[u]) {
                int nd = d - w;
                if (nd < 0) continue;
                if (dist[v] >= nd) continue;
                q.push({nd, v});
            }
        }
        int ans = 0;
        for (int d: dist) ans += d >= 0;
        for (auto &e: edges) {
            int d1 = dist[e[0]], d2 = dist[e[1]];
            if (d1 == -1 && d2 == -1) continue;
            if (d1 == -1) d1 = 0;
            if (d2 == -1) d2 = 0;
            ans += min(d1+d2, e[2]);
        }
        return ans;
    }
};