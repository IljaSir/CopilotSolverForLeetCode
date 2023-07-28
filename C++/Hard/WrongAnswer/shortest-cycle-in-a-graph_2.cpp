class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> dist(n, INT_MAX);
        int res = INT_MAX;
        for (int i = 0; i < n; ++i) {
            dist[i] = 0;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int v : graph[u]) {
                    if (dist[v] == INT_MAX) {
                        dist[v] = dist[u] + 1;
                        q.push(v);
                    } else if (v != i) {
                        res = min(res, dist[u] + dist[v] + 1);
                    }
                }
            }
            fill(dist.begin(), dist.end(), INT_MAX);
        }
        return res == INT_MAX ? -1 : res;
    }
};