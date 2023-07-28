class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<vector<int>> graph(n);
        for (auto& p : richer) {
            graph[p[1]].push_back(p[0]);
        }
        vector<int> res(n, -1);
        for (int i = 0; i < n; ++i) {
            dfs(i, graph, quiet, res);
        }
        return res;
    }
    
    int dfs(int i, vector<vector<int>>& graph, vector<int>& quiet, vector<int>& res) {
        if (res[i] == -1) {
            res[i] = i;
            for (int j : graph[i]) {
                if (quiet[res[i]] > quiet[dfs(j, graph, quiet, res)]) {
                    res[i] = res[j];
                }
            }
        }
        return res[i];
    }
};