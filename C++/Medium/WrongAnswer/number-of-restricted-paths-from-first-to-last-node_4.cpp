class Solution {
public:
    int countRestrictedPaths(int n, vector<vector<int>>& edges) {
        
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto& edge: edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
            graph[edge[1]].push_back({edge[0], edge[2]});
        }
        vector<int> dist(n + 1, INT_MAX);
        dist[n] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, n});
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int u = p.second;
            int d = p.first;
            if (d > dist[u]) continue;
            for (auto& e: graph[u]) {
                int v = e.first;
                int w = e.second;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.push({dist[v], v});
                }
            }
        }
        vector<int> dp(n + 1, 0);
        dp[n] = 1;
        pq.push({dist[n], n});
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int u = p.second;
            int d = p.first;
            if (d < dist[u]) continue;
            for (auto& e: graph[u]) {
                int v = e.first;
                int w = e.second;
                if (dist[v] < dist[u]) {
                    dp[v] = (dp[v] + dp[u]) % (int)(1e9 + 7);
                    pq.push({dist[v], v});
                }
            }
        }
        return dp[1];
    }
};