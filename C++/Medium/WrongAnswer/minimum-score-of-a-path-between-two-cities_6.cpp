class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int,int>>> adj(n);
        for (auto r: roads) {
            adj[r[0]-1].push_back({r[1]-1,r[2]});
            adj[r[1]-1].push_back({r[0]-1,r[2]});
        }
        vector<int> dist(n, INT_MAX);
        vector<bool> visited(n, false);
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        pq.push({0,0});
        while (!pq.empty()) {
            auto [d, u] = pq.top();
            pq.pop();
            if (visited[u]) continue;
            visited[u] = true;
            dist[u] = d;
            for (auto [v, w]: adj[u]) {
                if (visited[v]) continue;
                pq.push({max(d,w),v});
            }
        }
        return dist[n-1];
    }
};