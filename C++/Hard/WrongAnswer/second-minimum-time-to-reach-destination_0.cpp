class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0] - 1].push_back(e[1] - 1);
            graph[e[1] - 1].push_back(e[0] - 1);
        }
        vector<int> dist(n, INT_MAX);
        dist[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : graph[u]) {
                if (dist[v] == INT_MAX) {
                    dist[v] = dist[u] + time;
                    q.push(v);
                } else if (dist[v] > dist[u] + time) {
                    int prev = dist[v];
                    dist[v] = dist[u] + time;
                    if ((dist[v] / change) % 2 == (dist[u] / change) % 2) {
                        dist[v] = (dist[v] / change + 1) * change;
                    }
                    if (dist[v] < prev) {
                        q.push(v);
                    }
                }
            }
        }
        return dist[n - 1];
    }
};