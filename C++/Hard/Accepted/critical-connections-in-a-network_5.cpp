class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : connections) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> low(n, -1);
        vector<int> dfn(n, -1);
        vector<vector<int>> result;
        function<void(int, int, int&)> dfs = [&](int u, int parent, int& time) {
            low[u] = dfn[u] = ++time;
            for (int v : graph[u]) {
                if (v == parent) continue;
                if (dfn[v] == -1) {
                    dfs(v, u, time);
                    low[u] = min(low[u], low[v]);
                    if (low[v] > dfn[u]) {
                        result.push_back({u, v});
                    }
                } else {
                    low[u] = min(low[u], dfn[v]);
                }
            }
        };
        int time = 0;
        dfs(0, 0, time);
        return result;
    }
};