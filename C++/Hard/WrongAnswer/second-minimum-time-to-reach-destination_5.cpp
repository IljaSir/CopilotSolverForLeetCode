class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<int>> g(n+1);
        for (auto& e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dist(n+1, INT_MAX);
        queue<int> q;
        q.push(1);
        dist[1] = 0;
        while (!q.empty()) {
            int u = q.front(); q.pop();
            for (auto& v: g[u]) {
                int w = dist[u] + time;
                if (dist[u] % change < change - 1) {
                    w += change - 1 - dist[u] % change;
                }
                if (w < dist[v]) {
                    dist[v] = w;
                    q.push(v);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 1; i <= n; ++i) {
            if (i != 1 && dist[i] < ans) {
                ans = dist[i];
            }
        }
        return ans;
    }
};