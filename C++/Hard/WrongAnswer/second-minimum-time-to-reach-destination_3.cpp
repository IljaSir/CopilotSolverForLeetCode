class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0] - 1].push_back(e[1] - 1);
            adj[e[1] - 1].push_back(e[0] - 1);
        }
        vector<int> dist(n, INT_MAX);
        vector<int> cycle(n, INT_MAX);
        dist[0] = 0;
        cycle[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int u = q.front(); q.pop();
            for (int v : adj[u]) {
                int t = dist[u] + time;
                int c = (t / change) * change;
                if (t % change != 0) c += change;
                if (c < cycle[v]) {
                    cycle[v] = c;
                    dist[v] = c + time;
                    q.push(v);
                } else if (c == cycle[v] && dist[v] > t + time) {
                    dist[v] = t + time;
                    q.push(v);
                }
            }
        }
        return dist[n - 1];
    }
};