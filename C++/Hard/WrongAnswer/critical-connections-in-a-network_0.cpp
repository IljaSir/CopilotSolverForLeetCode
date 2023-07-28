class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& c : connections) {
            graph[c[0]].push_back(c[1]);
            graph[c[1]].push_back(c[0]);
        }
        vector<vector<int>> ans;
        vector<int> rank(n, -1);
        function<int(int,int)> dfs = [&](int u, int p) {
            rank[u] = 0;
            for (auto& v : graph[u]) {
                if (v == p) continue;
                if (rank[v] == -1) {
                    rank[u] = max(rank[u], dfs(v, u) + 1);
                } else {
                    rank[u] = max(rank[u], rank[v] + 1);
                }
            }
            if (rank[u] == 0) ans.push_back({u, p});
            return rank[u];
        };
        dfs(0, -1);
        return ans;
    }
};