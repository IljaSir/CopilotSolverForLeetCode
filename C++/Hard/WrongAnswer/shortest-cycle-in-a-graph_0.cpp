class Solution {
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n);
        for (auto e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dist(n, n + 1);
        vector<int> pre(n, -1);
        queue<int> q;
        for (int i = 0; i < n; i++) {
            dist[i] = 0;
            q.push(i);
            while (!q.empty()) {
                int x = q.front();
                q.pop();
                for (int y : g[x]) {
                    if (y == pre[x]) continue;
                    if (dist[y] == n + 1) {
                        dist[y] = dist[x] + 1;
                        pre[y] = x;
                        q.push(y);
                    } else {
                        return dist[x] + dist[y] + 1;
                    }
                }
            }
            dist[i] = n + 1;
        }
        return -1;
    }
};