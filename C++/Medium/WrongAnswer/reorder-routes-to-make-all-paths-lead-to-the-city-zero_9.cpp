class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> g(n);
        vector<vector<int>> rg(n);
        vector<bool> visited(n, false);
        for (int i = 0; i < connections.size(); ++i) {
            g[connections[i][0]].push_back(connections[i][1]);
            rg[connections[i][1]].push_back(connections[i][0]);
        }
        int result = 0;
        dfs(g, 0, visited, result);
        dfs(rg, 0, visited, result);
        return result;
    }
    
    void dfs(vector<vector<int>>& g, int u, vector<bool>& visited, int& result) {
        visited[u] = true;
        for (int i = 0; i < g[u].size(); ++i) {
            int v = g[u][i];
            if (!visited[v]) {
                result++;
                dfs(g, v, visited, result);
            }
        }
    }
};