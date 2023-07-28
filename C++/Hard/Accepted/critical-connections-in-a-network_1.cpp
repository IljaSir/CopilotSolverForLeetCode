class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& c : connections) {
            graph[c[0]].push_back(c[1]);
            graph[c[1]].push_back(c[0]);
        }
        vector<int> low(n, -1), dfn(n, -1);
        vector<vector<int>> res;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (dfn[i] == -1) {
                dfs(i, -1, graph, low, dfn, time, res);
            }
        }
        return res;
    }
    void dfs(int u, int parent, vector<vector<int>>& graph, vector<int>& low, vector<int>& dfn, int& time, vector<vector<int>>& res) {
        low[u] = dfn[u] = time++;
        for (int v : graph[u]) {
            if (v == parent) continue;
            if (dfn[v] == -1) {
                dfs(v, u, graph, low, dfn, time, res);
                low[u] = min(low[u], low[v]);
                if (low[v] > dfn[u]) {
                    res.push_back({u, v});
                }
            } else {
                low[u] = min(low[u], dfn[v]);
            }
        }
    }
};