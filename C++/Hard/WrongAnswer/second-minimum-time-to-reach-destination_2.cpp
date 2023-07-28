class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        
        vector<vector<int>> g(n);
        for (auto& e: edges) {
            g[e[0] - 1].push_back(e[1] - 1);
            g[e[1] - 1].push_back(e[0] - 1);
        }
        vector<int> dist(n, INT_MAX);
        queue<int> q;
        q.push(0);
        dist[0] = 0;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v: g[u]) {
                int t = dist[u] + time;
                t += change - t % change;
                if (dist[v] > t) {
                    dist[v] = t;
                    q.push(v);
                }
            }
        }
        int minTime = dist[n - 1];
        int secondMinTime = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (dist[i] == minTime) {
                for (int j: g[i]) {
                    if (dist[j] != minTime) {
                        secondMinTime = min(secondMinTime, dist[j]);
                    }
                }
            }
        }
        return secondMinTime;
    }
};