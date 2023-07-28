class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        int ans = INT_MAX;
        for (auto& e : edges) {
            vector<int> dist(n, INT_MAX);
            queue<int> q;
            q.push(e[0]);
            dist[e[0]] = 0;
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int v : graph[u]) {
                    if (dist[v] == INT_MAX) {
                        dist[v] = dist[u] + 1;
                        q.push(v);
                    } else if (v == e[1]) {
                        ans = min(ans, dist[u] + 1);
                    }
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};