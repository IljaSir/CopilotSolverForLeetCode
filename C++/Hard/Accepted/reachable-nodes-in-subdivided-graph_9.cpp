class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int maxMoves, int n) {
        
        vector<vector<pair<int,int>>> graph(n);
        for(auto& e: edges) {
            graph[e[0]].push_back({e[1], e[2]});
            graph[e[1]].push_back({e[0], e[2]});
        }
        priority_queue<pair<int,int>> pq;
        pq.push({maxMoves, 0});
        vector<int> dist(n, -1);
        while(!pq.empty()) {
            int d = pq.top().first;
            int u = pq.top().second;
            pq.pop();
            if(dist[u] != -1) continue;
            dist[u] = d;
            for(auto& p: graph[u]) {
                int v = p.first;
                int w = p.second;
                if(dist[v] == -1 && d - w - 1 >= 0) {
                    pq.push({d - w - 1, v});
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; ++i) ans += dist[i] >= 0;
        for(auto& e: edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            int d1 = dist[u] == -1 ? 0 : dist[u];
            int d2 = dist[v] == -1 ? 0 : dist[v];
            ans += min(d1 + d2, w);
        }
        return ans;
    }
};