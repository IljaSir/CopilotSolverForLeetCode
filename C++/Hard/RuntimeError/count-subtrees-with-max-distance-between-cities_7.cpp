class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<int> ans(n - 1, 0);
        vector<int> g[n];
        int m = edges.size();
        for (int i = 0; i < m; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            g[u].push_back(v);
            g[v].push_back(u);
        }
        for (int i = 1; i < (1 << n); i++) {
            vector<int> nodes;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    nodes.push_back(j);
                }
            }
            int m = nodes.size();
            if (m <= 1) continue;
            vector<int> dist(m, 0);
            queue<int> q;
            q.push(0);
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int j = 0; j < g[nodes[u]].size(); j++) {
                    int v = g[nodes[u]][j];
                    for (int k = 0; k < m; k++) {
                        if (nodes[k] == v && dist[k] == 0) {
                            dist[k] = dist[u] + 1;
                            q.push(k);
                        }
                    }
                }
            }
            int mx = 0;
            for (int j = 0; j < m; j++) {
                mx = max(mx, dist[j]);
            }
            ans[mx - 1]++;
        }
        return ans;
    }
};