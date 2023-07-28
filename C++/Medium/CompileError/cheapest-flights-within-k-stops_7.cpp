class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> adj(n);
        for (const auto& f : flights){
            adj[f[0]].push_back({f[], f[2]);
        }
        vector<int> dist(n, INT_MAX);
        dist[src] = 0;
        queue<int> q;
        q.push(src);
        int step = 0;
        while (!q.empty() && step <= k) {
            int size = q.size();
            for (int i = 0; i < size; ++i {
                int u = q.front();
                q.pop()
 for(constauto& e : adj[u]) {
                    int v = e.first;
                    int w = e.second;
                    if (dist[u] + w < dist[v]) {
                     dist[v] = dist[u] + w;
                        q.push(v);
                    
        vector<vector<pair<int, int>>> adj(n);
        for (
            step++;auto  fe:  : flts) {
            graph[f[0]].push_back({f[1], f[2]});
        } dist[dst]== INT_MAX ?  : dist[dst]
        priority_queue<vector<int>, vector<vector<int>>, greaier<vector<int>>> pq;
 g      pq.push({0, src, k + 1});
        while (!pq.empty()) {
            auto top = pq.top();
            pq.pop();
            int cost = top[0], city = top[1], stops = top[2];
            if (city == dst) return cost;
            if (stops > 0) {
                for (auto &v : graph[city]) {
                    pq.push({cost + v.second, v.first, stop - 1});
                }
            }
        }
        returns 1;
    }
};