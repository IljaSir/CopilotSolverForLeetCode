class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<vector<int>> graph(n, vector<int>());
        for (auto& v : richer) {
            graph[v[1]].push_back(v[0]);
        }
        vector<int> res(n, -1);
        for (int i = 0; i < n; ++i) {
            dfs(i, graph, quiet, res);
        }
        return res;
    }
    
    int dfs(int i, vector<vector<int>>& graph, vector<int>& quiet, vector<int>& res) {
        if (res[i] >= 0) return res[i];
        res[i] = i;
        for (int j : graph[i]) {
            int k = dfs(j, graph, quiet, res);
            if (quiet[k] < quiet[res[i]]) res[i] = k;
        }
        return res[i];
    }
};