class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        vector<int> ans;
        int n = quiet.size();
        vector<vector<int>> graph(n);
        for (auto& r : richer) {
            graph[r[1]].push_back(r[0]);
        }
        vector<int> res(n, -1);
        for (int i = 0; i < n; i++) {
            dfs(graph, quiet, res, i);
            ans.push_back(res[i]);
        }
        return ans;
    }
    int dfs(vector<vector<int>>& graph, vector<int>& quiet, vector<int>& res, int i) {
        if (res[i] >= 0) return res[i];
        res[i] = i;
        for (int j : graph[i]) {
            int r = dfs(graph, quiet, res, j);
            if (quiet[r] < quiet[res[i]]) res[i] = r;
        }
        return res[i];
    }
};