class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        int res = n + 1;
        vector<int> dist(n, n + 1);
        for (int i = 0; i < n; ++i) {
            queue<int> q;
            q.push(i);
            dist[i] = 0;
            while (!q.empty()) {
                int node = q.front();
                q.pop();
                for (int neighbor : graph[node]) {
                    if (dist[neighbor] == n + 1) {
                        dist[neighbor] = dist[node] + 1;
                        q.push(neighbor);
                    } else if (dist[neighbor] >= dist[node]) {
                        res = min(res, dist[neighbor] + dist[node] + 1);
                    }
                }
            }
            fill(dist.begin(), dist.end(), n + 1);
        }
        return res == n + 1 ? -1 : res;
    }
};