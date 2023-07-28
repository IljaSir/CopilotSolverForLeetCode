class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        
        if (source == target) return 0;
        int n = routes.size();
        vector<vector<int>> g(n);
        unordered_map<int, vector<int>> rec;
        for (int i = 0; i < n; i++) {
            for (auto site : routes[i]) {
                for (auto j : rec[site]) {
                    g[i].push_back(j);
                    g[j].push_back(i);
                }
                rec[site].push_back(i);
            }
        }
        queue<int> q;
        vector<int> dist(n, INT_MAX);
        for (auto site : rec[source]) {
            q.push(site);
            dist[site] = 1;
        }
        while (!q.empty()) {
            int x = q.front();
            q.pop();
            for (auto y : g[x]) {
                if (dist[y] > dist[x] + 1) {
                    dist[y] = dist[x] + 1;
                    q.push(y);
                }
            }
        }
        int ret = INT_MAX;
        for (auto site : rec[target]) {
            if (dist[site] != INT_MAX) {
                ret = min(ret, dist[site]);
            }
        }
        return ret == INT_MAX ? -1 : ret;
    }
};