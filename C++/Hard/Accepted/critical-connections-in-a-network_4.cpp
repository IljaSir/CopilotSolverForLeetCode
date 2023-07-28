class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> edges(n, vector<int>());
        for (auto& c : connections) {
            edges[c[0]].push_back(c[1]);
            edges[c[1]].push_back(c[0]);
        }
        vector<vector<int>> res;
        vector<int> disc(n, 0), low(n, 0);
        vector<bool> visited(n, false);
        dfs(edges, 0, -1, 0, disc, low, visited, res);
        return res;
    }
    
    void dfs(vector<vector<int>>& edges, int u, int parent, int time, vector<int>& disc, vector<int>& low, vector<bool>& visited, vector<vector<int>>& res) {
        visited[u] = true;
        disc[u] = time;
        low[u] = time;
        for (int v : edges[u]) {
            if (v == parent) continue;
            if (!visited[v]) {
                dfs(edges, v, u, time + 1, disc, low, visited, res);
                low[u] = min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.push_back({u, v});
                }
            } else {
                low[u] = min(low[u], disc[v]);
            }
        }
    }
};