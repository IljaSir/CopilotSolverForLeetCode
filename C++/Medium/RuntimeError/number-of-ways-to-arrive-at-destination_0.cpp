class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto road : roads) {
            graph[road[0]].push_back({road[1], road[2]});
            graph[road[1]].push_back({road[0], road[2]});
        }
        
        vector<int> dist(n, INT_MAX);
        vector<int> ways(n, 0);
        dist[0] = 0;
        ways[0] = 1;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, 0});
        
        while (!pq.empty()) {
            int d = pq.top().first;
            int u = pq.top().second;
            pq.pop();
            
            if (d > dist[u]) continue;
            
            for (auto v : graph[u]) {
                int d2 = d + v.second;
                if (d2 < dist[v.first]) {
                    dist[v.first] = d2;
                    ways[v.first] = ways[u];
                    pq.push({d2, v.first});
                } else if (d2 == dist[v.first]) {
                    ways[v.first] = (ways[v.first] + ways[u]) % 1000000007;
                }
            }
        }
        
        return ways[n - 1];
    }
};