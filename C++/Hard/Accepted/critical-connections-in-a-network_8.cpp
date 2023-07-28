class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> ans;
        vector<int> disc(n, -1);
        vector<int> low(n, -1);
        vector<vector<int>> graph(n);
        for (auto& c : connections) {
            graph[c[0]].push_back(c[1]);
            graph[c[1]].push_back(c[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (disc[i] == -1) {
                dfs(i, -1, 0, disc, low, graph, ans);
            }
        }
        return ans;
    }
    void dfs(int u, int p, int time, vector<int>& disc, vector<int>& low, vector<vector<int>>& graph, vector<vector<int>>& ans) {
        disc[u] = low[u] = time;
        for (auto& v : graph[u]) {
            if (v == p) {
                continue;
            }
            if (disc[v] == -1) {
                dfs(v, u, time + 1, disc, low, graph, ans);
                low[u] = min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    ans.push_back({u, v});
                }
            } else {
                low[u] = min(low[u], disc[v]);
            }
        }
    }
};