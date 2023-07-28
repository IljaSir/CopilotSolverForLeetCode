class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> dist(n, INT_MAX);
        int res = INT_MAX;
        for (int i = 0; i < n; ++i) {
            queue<int> q;
            q.push(i);
            dist[i] = 0;
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int v : adj[u]) {
                    if (dist[v] == INT_MAX) {
                        dist[v] = dist[u] + 1;
                        q.push(v);
                    } else if (v != i && dist[v] >= dist[u]) {
                        res = min(res, dist[v] + dist[u] + 1);
                    }
                }
            }
            fill(begin(dist), end(dist), INT_MAX);
        }
        return res == INT_MAX ? -1 : res;
    }
};