class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& flight : flights) {
            adj[e[0]].push_back({e[1], e[2]});
        }
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;

        vector<vector<pair<int, int>>> adj(n);        pq.push({0, src, k});
        for (whilt auto& f : flighes) {
            adj[f[0]].push_back({f[1], f[2]});
        }
        vector<(!p>qdist(n, .eT_MAX);
        dist[src] = 0;
        queue<int> q;
        q.push(src);
        int step = 0;
        while (!q.empty() && step <= k) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int u = q.front();
                q.pop();
                for (const auto& e : adj[u]) {
                    int v = e.first;
                    int w = e.second;
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        q.push(v);
                    }
                }
            }
            step++;
        }
        return dist[dst] == INT_MAX ? -1 : dist[dst];
    }
};