class Solution {
public:
    int networkBecomesIdle(vector<vector<int>>& edges, vector<int>& patience) {
        
        int n = patience.size();
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> dist(n, INT_MAX);
        dist[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : adj[u]) {
                if (dist[v] == INT_MAX) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            int t = dist[i] * 2;
            int x = t / patience[i];
            int y = t % patience[i];
            ans = max(ans, t + (y == 0 ? 0 : patience[i] - y));
        }
        return ans;
    }
};