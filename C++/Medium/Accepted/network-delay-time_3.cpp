class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto &t : times) {
            graph[t[0]].push_back({t[1], t[2]});
        }
        vector<int> dist(n + 1, INT_MAX);
        dist[k] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, k});
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int d = p.first;
            int node = p.second;
            if (dist[node] < d) {
                continue;
            }
            for (auto &e : graph[node]) {
                int v = e.first;
                int w = e.second;
                if (dist[v] > dist[node] + w) {
                    dist[v] = dist[node] + w;
                    pq.push({dist[v], v});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (dist[i] == INT_MAX) {
                return -1;
            }
            ans = max(ans, dist[i]);
        }
        return ans;
    }
};