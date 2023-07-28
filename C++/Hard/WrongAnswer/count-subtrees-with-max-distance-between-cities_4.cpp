class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<int> ans(n-1, 0);
        vector<vector<int>> g(n+1);
        for (auto e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        for (int mask = 1; mask < (1<<n); ++mask) {
            vector<int> path;
            int root = 0;
            for (int i = 0; i < n; ++i) {
                if (mask & (1<<i)) {
                    root = i + 1;
                    break;
                }
            }
            dfs(root, g, mask, path);
            int maxd = 0;
            for (int i = 0; i < path.size(); ++i) {
                for (int j = i+1; j < path.size(); ++j) {
                    maxd = max(maxd, dist(path[i], path[j], g));
                }
            }
            if (maxd > 0) ans[maxd-1] += 1;
        }
        return ans;
    }
    void dfs(int root, vector<vector<int>>& g, int mask, vector<int>& path) {
        path.push_back(root);
        for (auto v : g[root]) {
            if ((mask & (1<<(v-1))) && find(path.begin(), path.end(), v) == path.end()) {
                dfs(v, g, mask, path);
            }
        }
    }
    int dist(int x, int y, vector<vector<int>>& g) {
        queue<int> q;
        q.push(x);
        vector<int> dist(g.size(), -1);
        dist[x] = 0;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (auto v : g[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        return dist[y];
    }
};