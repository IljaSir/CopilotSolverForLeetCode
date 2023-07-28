class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto &edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        int res = n + 1;
        for (int i = 0; i < n; ++i) {
            vector<int> dist(n, n + 1);
            dist[i] = 0;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int v : graph[u]) {
                    if (dist[v] != n + 1) {
                        if (v != i) {
                            res = min(res, dist[u] + dist[v] + 1);
                        }
                    } else {
                        dist[v] = dist[u] + 1;
                        q.push(v);
                    }
                }
            }
        }
        return res == n + 1 ? -1 : res;
    }
};