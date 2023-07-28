class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            vector<int> dist(n, n + 1), pre(n, -1);
            dist[i] = 0;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int v : adj[u]) {
                    if (v == pre[u]) continue;
                    if (dist[v] < n + 1) {
                        res = min(res, dist[u] + dist[v] + 1);
                    } else {
                        dist[v] = dist[u] + 1;
                        pre[v] = u;
                        q.push(v);
                    }
                }
            }
        }
        return res == n + 1 ? -1 : res;
    }
};